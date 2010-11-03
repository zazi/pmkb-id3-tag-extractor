/**
 * Copyright (c) 2006 - 2008 Aduna and Deutsches Forschungszentrum fuer Kuenstliche Intelligenz DFKI GmbH.
 * Copyright (c) 2010 SMI.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 * 
 * @author Bob Ferris
 */
package smiy.pmkb.extractor.audiodocuments.mp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3v11Tag;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.ontoware.rdf2go.exception.ModelException;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.ontoware.rdf2go.vocabulary.RDF;
import org.ontoware.rdf2go.vocabulary.XSD;
import org.semanticdesktop.aperture.extractor.AbstractFileExtractor;
import org.semanticdesktop.aperture.extractor.ExtractorException;
import org.semanticdesktop.aperture.rdf.RDFContainer;
import org.semanticdesktop.aperture.rdf.util.ModelUtil;
import org.semanticdesktop.aperture.vocabulary.NID3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import smiy.pmkb.util.Namespaces;
import smiy.pmkb.vocabulary.DC;
import smiy.pmkb.vocabulary.DCTERMS;
import smiy.pmkb.vocabulary.EVENT;
import smiy.pmkb.vocabulary.FOAF;
import smiy.pmkb.vocabulary.MFO;
import smiy.pmkb.vocabulary.MO;
import smiy.pmkb.vocabulary.TIME;
import smiy.pmkb.vocabulary.TL;

/**
 * A file extractor implementation for MP3 files.
 */
public class MP3FileExtractor extends AbstractFileExtractor
{

	private HashMap<String, Resource> resourceMap;

	private Logger logger = LoggerFactory.getLogger(MP3FileExtractor.class);

	/**
	 * Extracts ID3 metadata from an MP3 file
	 * 
	 * @param id
	 *            the URI of the file
	 * @param file
	 *            the java.io.File instance representing the path to the MP3
	 *            file. It is assumed that the file exists and is readable.
	 * @param charset
	 *            ignored in this implementation
	 * @param mimeType
	 *            ignored in this implementation
	 * @param result
	 *            the RDFContainer where the generated triples should be stored
	 */
	protected void performExtraction(URI id, File file, Charset charset,
			String mimeType, RDFContainer result) throws ExtractorException
	{
		MP3File mp3File = null;

		Model model = result.getModel();

		Resource track = ModelUtil.generateRandomResource(model);
		Resource musicAlbum = ModelUtil.generateRandomResource(model);
		Resource release = ModelUtil.generateRandomResource(model);
		Resource releaseEvent = ModelUtil.generateRandomResource(model);

		resourceMap = new HashMap<String, Resource>();

		resourceMap.put(ID3Util.TRACK, track);
		resourceMap.put(ID3Util.MUSICALBUM, musicAlbum);
		resourceMap.put(ID3Util.RELEASE, release);
		resourceMap.put(ID3Util.RELEASEEVENT, releaseEvent);

		model.addStatement(track, MO.available_as, result.getDescribedUri());
		model.addStatement(track, RDF.type, MO.Track);

		try
		{
			// we want to open the file in write mode
			mp3File = new MP3File(file);
		}
		catch (FileNotFoundException e)
		{
			throw new ExtractorException(e);
		}
		catch (IOException e)
		{
			throw new ExtractorException(e);
		}
		catch (TagException e)
		{
			throw new ExtractorException(
					"File format not supported by the MP3Exctractor: "
							+ file.getParent(), e);
		}
		catch (ReadOnlyFileException e)
		{
			throw new ExtractorException(e);
		}
		catch (InvalidAudioFrameException e)
		{
			throw new ExtractorException(e);
		}

		HashMap<URI, String> id3v1hashMap = new HashMap<URI, String>();

		if (mp3File.hasID3v1Tag())
		{
			processID3V1Tags(id, mp3File, charset, mimeType, id3v1hashMap);
		}

		if (mp3File.hasID3v2Tag())
		{
			processID3V2Tags(id, mp3File, charset, mimeType, id3v1hashMap,
					result);
		}

		/*
		 * now that we processed all the ID3V2 tags, we can add the remaining
		 * id3v1 fields we do it now because after processing id3v2 frames the
		 * id3v1 fields may have been obsoleted this solution is better because
		 * the extractor doesn't need to delete anything from the rdfcontainer
		 */
		addId3V1Fields(id3v1hashMap, result);
		/*
		 * if (mp3File.hasFilenameTag()) { processFilenameTag(id, mp3File,
		 * charset, mimeType, result); }
		 * 
		 * if (mp3File.hasLyrics3Tag()) { processLyrics3Tag(id, mp3File,
		 * charset, mimeType, result); }
		 */
		result.add(RDF.type, MO.AudioFile);
		result.add(RDF.type, MFO.Digital_Media);

	}

	private void processID3V1Tags(URI id, MP3File mp3File, Charset charset,
			String mimeType, HashMap<URI, String> resultHashMap)
	{

		ID3v1Tag id3v1 = mp3File.getID3v1Tag();

		// note that getSongTitle is the same as getTitle().trim() - viva la
		// open source
		addStringProperty(DC.title, id3v1.getFirstTitle(), resultHashMap);

		// note that getLeadArtist is the same as getArtist().trim()
		// FIXME: NID3.leadArtist is currently used for identification purpose
		// for further processing in addId3V1Fields
		addStringProperty(NID3.leadArtist, id3v1
				.getFirst(FieldKey.ALBUM_ARTIST), resultHashMap);

		// note that getAlbumTitle is the same as getAlbum().trim()
		// FIXME: NID3.albumTitle is currently used for identification purpose
		// for further processing in addId3V1Fields
		addStringProperty(NID3.albumTitle, id3v1.getFirst(FieldKey.ALBUM),
				resultHashMap);

		// note that getYearReleased is the same as getYear().trim()
		// FIXME: NID3.recordingYear is currently used for identification
		// purpose
		// for further processing in addId3V1Fields
		addStringProperty(NID3.recordingYear, id3v1.getFirstYear(),
				resultHashMap);

		// note that getSongComment is the same as getComment().trim()
		addStringProperty(DC.description, id3v1.getFirstComment(),
				resultHashMap);

		// FIXME: NID3.contentType is currently used for identification purpose
		// for further processing in addId3V1Fields
		addStringProperty(NID3.contentType, id3v1.getFirstGenre(),
				resultHashMap);

		if (id3v1 instanceof ID3v11Tag)
		{
			ID3v11Tag id3v1_1 = (ID3v11Tag) id3v1;
			// FIXME: NID3.trackNumber is currently used for identification
			// purpose
			// for further processing in addId3V1Fields
			addStringProperty(NID3.trackNumber, id3v1_1.getFirstTrack(),
					resultHashMap);
		}
	}

	private void processID3V2Tags(URI id, MP3File mp3File, Charset charset,
			String mimeType, HashMap<URI, String> id3v1FieldHashMap,
			RDFContainer result)
	{
		Model model = result.getModel();

		Resource trackArtist = ModelUtil.generateRandomResource(model);
		Resource signal = ModelUtil.generateRandomResource(model);
		Resource musicalWork = ModelUtil.generateRandomResource(model);
		Resource lyrics = ModelUtil.generateRandomResource(model);
		Resource originalSignal = ModelUtil.generateRandomResource(model);
		Resource originalMusicalManifestation = ModelUtil
				.generateRandomResource(model);
		Resource originalLyrics = ModelUtil.generateRandomResource(model);
		Resource performance = ModelUtil.generateRandomResource(model);
		Resource musicSegment = ModelUtil.generateRandomResource(model);
		Resource segmentInterval = ModelUtil.generateRandomResource(model);
		Resource episodeTimeline = ModelUtil.generateRandomResource(model);
		Resource versionInterval = ModelUtil.generateRandomResource(model);
		Resource episodeVersion = ModelUtil.generateRandomResource(model);
		Resource broadcast = ModelUtil.generateRandomResource(model);
		Resource outlet = ModelUtil.generateRandomResource(model);
		Resource service = ModelUtil.generateRandomResource(model);
		Resource albumArtist = ModelUtil.generateRandomResource(model);
		Resource signalGroup = ModelUtil.generateRandomResource(model);
		Resource label = ModelUtil.generateRandomResource(model);

		resourceMap.put(ID3Util.TRACKARTIST, trackArtist);
		resourceMap.put(ID3Util.SIGNAL, signal);
		resourceMap.put(ID3Util.MUSICALWORK, musicalWork);
		resourceMap.put(ID3Util.LYRICS, lyrics);
		resourceMap.put(ID3Util.ORIGINALSIGNAL, originalSignal);
		resourceMap.put(ID3Util.ORIGINALMUSICALMANIFESTATION,
				originalMusicalManifestation);
		resourceMap.put(ID3Util.ORIGINALLYRICS, originalLyrics);
		resourceMap.put(ID3Util.PERFORMANCE, performance);
		resourceMap.put(ID3Util.MUSICSEGMENT, musicSegment);
		resourceMap.put(ID3Util.SEGMENTINTERVAL, segmentInterval);
		resourceMap.put(ID3Util.EPISODETIMELINE, episodeTimeline);
		resourceMap.put(ID3Util.VERSIONINTERVAL, versionInterval);
		resourceMap.put(ID3Util.EPISODEVERSION, episodeVersion);
		resourceMap.put(ID3Util.BROADCAST, broadcast);
		resourceMap.put(ID3Util.OUTLET, outlet);
		resourceMap.put(ID3Util.SERVICE, service);
		resourceMap.put(ID3Util.ALBUMARTIST, albumArtist);
		resourceMap.put(ID3Util.SIGNALGROUP, signalGroup);
		resourceMap.put(ID3Util.LABEL, label);

		AbstractID3v2Tag id3v2 = mp3File.getID3v2Tag();

		Iterator iterator = id3v2.getFields();
		while (iterator.hasNext())
		{
			AbstractID3v2Frame frame = (AbstractID3v2Frame) iterator.next();
			String identifier = frame.getIdentifier();
			try
			{
				FrameIdentifier frameIdentifier = FrameIdentifier
						.valueOf(identifier.trim());
				AbstractTagFrameBody body = frame.getBody();
				frameIdentifier.process(body, id3v2, id3v1FieldHashMap, result,
						resourceMap);
			}
			catch (Exception e)
			{
				logger.warn("Problem while getting the frame '" + identifier
						+ "' from file " + id, e);
			}
		}
	}

	/**
	 * Add a key value pair only to the hash map, if the string isn't 'null' or
	 * greater than 0
	 * 
	 * @param property
	 *            - the key (a URI)
	 * @param string
	 *            - the value
	 * @param resultHashMap
	 *            - the map
	 */
	private void addStringProperty(URI property, String string,
			HashMap<URI, String> resultHashMap)
	{
		if (string != null && string.length() > 0)
		{
			resultHashMap.put(property, string);
		}
	}

	private void addId3V1Fields(HashMap<URI, String> id3v1hashMap,
			RDFContainer result)
	{
		Model model = result.getModel();

		for (Map.Entry<URI, String> entry : id3v1hashMap.entrySet())
		{
			URI uri = entry.getKey();
			String value = entry.getValue();
			if (uri.equals(NID3.leadArtist))
			{
				ID3Util.checkStatementObject(model, resourceMap
						.get(ID3Util.TRACK), DCTERMS.creator, resourceMap
						.get(ID3Util.TRACKARTIST), MO.MusicArtist);
				ID3Util.addStringLiteral(model, resourceMap
						.get(ID3Util.TRACKARTIST), FOAF.name, value);
				continue;
			}
			else if (uri.equals(NID3.albumTitle))
			{
				ID3Util.checkStatementSubject(model, resourceMap
						.get(ID3Util.MUSICALBUM), MO.track, resourceMap
						.get(ID3Util.TRACK), MO.Record);
				ID3Util.addStringLiteral(model, resourceMap
						.get(ID3Util.MUSICALBUM), DC.title, value);
				continue;
			}
			else if (uri.equals(NID3.recordingYear))
			{
				try
				{
					int recordingYear = Integer.parseInt(value);
					if ((recordingYear > 0))
					{
						ID3Util.checkStatementSubject(model, resourceMap
								.get(ID3Util.MUSICALBUM), MO.track, resourceMap
								.get(ID3Util.TRACK), MO.Record);
						ID3Util.checkStatementSubject(model, resourceMap
								.get(ID3Util.RELEASE), MO.record, resourceMap
								.get(ID3Util.MUSICALBUM), MO.Release);
						ID3Util.checkStatementSubject(model, resourceMap
								.get(ID3Util.RELEASEEVENT), MO.release,
								resourceMap.get(ID3Util.RELEASE),
								MO.ReleaseEvent);

						// create time instant
						Resource releaseTime = ModelUtil
								.generateRandomResource(model);
						model.addStatement(resourceMap
								.get(ID3Util.RELEASEEVENT), EVENT.time,
								releaseTime);
						model.addStatement(releaseTime, RDF.type, TIME.Instant);
						try
						{
							model.addStatement(releaseTime, TL.atYear,
									ModelUtil.createLiteral(model, value,
											XSD._gYear));
						}
						catch (ModelRuntimeException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (ModelException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				catch (NumberFormatException nfe)
				{
					// TODO: do error handling
				}
			}
			else if (uri.equals(NID3.contentType))
			{
				if (Genre.getGenreByName(value) != null)
				{
					// FIXME: a music genre can also be item specific
					// (subjective, personal)
					model.addStatement(resourceMap.get(ID3Util.TRACK),
							MO.genre, GenreUri.getGenreUriByIntId(
									Genre.getGenreByName(value).getId())
									.getUri());
				}
				else
				{
					// introduce a new URI for a new music genre
					// TODO: write a proper music genre instantiation (with
					// duplicate check etc)
					// a music genre can also be item specific (subjective,
					// personal)
					model.addStatement(resourceMap.get(ID3Util.TRACK),
							MO.genre, new URIImpl(Namespaces.PMKB_NS
									+ GenreUri.GENRE_RURI + value));
				}
			}
			else if (uri.equals(NID3.trackNumber))
			{
				try
				{
					int trackNumber = Integer.parseInt(value);
					if (trackNumber > 0)
					{
						model.addStatement(resourceMap.get(ID3Util.TRACK),
								MO.track_number, ModelUtil.createLiteral(model,
										trackNumber));
					}
				}
				catch (NumberFormatException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (ModelRuntimeException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (ModelException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				// result.add(uri, value);
				// FIXME: add the property now to the mo:Track instance
				ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.TRACK),
						uri, value);
			}
		}
	}
}
