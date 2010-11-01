/**
 * Copyright (c) 2010 SMI.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 * 
 * @author Bob Ferris
 */
package smiy.pmkb.extractor.audiodocuments.mp3;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.ontoware.rdf2go.exception.ModelException;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.vocabulary.RDF;
import org.semanticdesktop.aperture.rdf.RDFContainer;
import org.semanticdesktop.aperture.rdf.util.ModelUtil;

import smiy.pmkb.vocabulary.DC;
import smiy.pmkb.vocabulary.DCTERMS;
import smiy.pmkb.vocabulary.FOAF;
import smiy.pmkb.vocabulary.FRBR;
import smiy.pmkb.vocabulary.MO;

/**
 * This class contains utility methods that facilitate the generation of various
 * values from an RDF2Go model.
 */
public class ID3Util
{
	/**
	 * As taken from the timestamp definition published at <br/>
	 * <br/>
	 * http://www.id3.org/id3v2.4.0-structure <br/>
	 * <br/>
	 * 
	 * <pre>
	 * The timestamp fields are based on a subset of ISO 8601. When being as
	 *    precise as possible the format of a time string is
	 *    yyyy-MM-ddTHH:mm:ss (year, "-", month, "-", day, "T", hour (out of
	 *    24), ":", minutes, ":", seconds), but the precision may be reduced by
	 *    removing as many time indicators as wanted. Hence valid timestamps
	 *    are
	 *    yyyy, yyyy-MM, yyyy-MM-dd, yyyy-MM-ddTHH, yyyy-MM-ddTHH:mm and
	 *    yyyy-MM-ddTHH:mm:ss. All time stamps are UTC. For durations, use
	 *    the slash character as described in 8601, and for multiple non-
	 *    contiguous dates, use multiple strings, if allowed by the frame
	 *    definition.
	 * </pre>
	 * 
	 * @param timestamp
	 * @return a {@link Date} instance corresponding to the given timestamp.
	 */
	public static Date id3v24timestampToDate(String timestamp)
	{
		// the Javadocs state that if the ID is not recognized, GMT is returned,
		// we need GMT
		GregorianCalendar result = new GregorianCalendar(TimeZone
				.getTimeZone("asdfasdfasd"));
		result.set(0, 0, 1, 0, 0, 0);
		// let's start by trying to set the year, without any further ado
		result.set(Calendar.YEAR, Integer.parseInt(timestamp.substring(0, 4)));
		if (timestamp.length() == 4)
		{
			return result.getTime();
		}
		// months in a GregorianCalendar are 0-based, that's why we subtract 1
		result.set(Calendar.MONTH,
				Integer.parseInt(timestamp.substring(5, 2)) - 1);
		if (timestamp.length() == 7)
		{
			return result.getTime();
		}
		result.set(Calendar.DAY_OF_MONTH, Integer.parseInt(timestamp.substring(
				8, 2)));
		if (timestamp.length() == 10)
		{
			return result.getTime();
		}
		result.set(Calendar.HOUR, Integer.parseInt(timestamp.substring(11, 2)));
		if (timestamp.length() == 13)
		{
			return result.getTime();
		}
		result.set(Calendar.MINUTE, Integer
				.parseInt(timestamp.substring(14, 2)));
		if (timestamp.length() == 16)
		{
			return result.getTime();
		}
		result.set(Calendar.SECOND, Integer
				.parseInt(timestamp.substring(17, 2)));
		return result.getTime();
	}

	public static void checkRecord(Model model, String value,
			Resource musicAlbum, Resource track)
	{
		if (!model.contains(ModelUtil.createStatement(model, musicAlbum,
				MO.track, track)))
		{
			model.addStatement(musicAlbum, MO.track, track);
			model.addStatement(musicAlbum, RDF.type, MO.Record);
		}

		try
		{
			model.addStatement(musicAlbum, DC.title, ModelUtil.createLiteral(
					model, value));
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

	public static void checkArtist(Model model, String value, Resource track)
	{
		// creates here a random URI for further processing (matching
		// task)
		Resource musicArtist = ModelUtil.generateRandomResource(model);
		model.addStatement(track, DCTERMS.creator, musicArtist);
		model.addStatement(musicArtist, RDF.type, MO.MusicArtist);
		try
		{
			model.addStatement(musicArtist, FOAF.name, ModelUtil.createLiteral(
					model, value));
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

	/**
	 * Tries to resolve an ID3 tag media type description to an URI.
	 * 
	 * TODO: add exceptions, especially NullPointerException
	 * 
	 * @param body
	 *            - the frame that contains a media type description
	 * @return - the URI of the specific media type
	 */
	public static URI getMediaType(AbstractFrameBodyTextInfo body)
	{
		String mediaType = body.getFirstTextValue();
		String mediaTypeShortened = "";
		URI mediaTypeUri = null;

		if (mediaType.length() > 3)
		{
			mediaTypeShortened = mediaType.substring(0, 2);
		}
		else
		{
			mediaTypeShortened = mediaType;
		}

		if (MediaTypeUri.getKeyByStringId(mediaTypeShortened) != null)
		{
			MediaTypeUri mediaTypeUriKey = MediaTypeUri
					.getKeyByStringId(mediaTypeShortened);

			// handle specific video media types (VHS, S-VHS, Betamax)
			if (mediaTypeUriKey == MediaTypeUri.VID)
			{
				// 4 letter endings, e.g. SVHS or BETA
				String mediaTypeShortenedEnd = mediaType.substring(mediaType
						.length() - 4, mediaType.length() - 1);

				if (MediaTypeUri.getKeyByStringId(mediaTypeShortenedEnd) != null)
				{
					mediaTypeUri = MediaTypeUri.getKeyByStringId(
							mediaTypeShortenedEnd).getUri();
				}
				else
				{
					// 3 letter endings, e.g. VHS
					mediaTypeShortenedEnd = mediaType.substring(mediaType
							.length() - 3, mediaType.length() - 1);

					if (MediaTypeUri.getKeyByStringId(mediaTypeShortenedEnd) != null)
					{
						mediaTypeUri = MediaTypeUri.getKeyByStringId(
								mediaTypeShortenedEnd).getUri();
					}
				}
			}
			else
			{
				mediaTypeUri = mediaTypeUriKey.getUri();
			}
		}
		// handle specific other analogue media types
		else if (mediaTypeShortened.equals("ANA"))
		{
			if (mediaType.length() >= 7)
			{
				mediaTypeShortened = mediaType.substring(0, 6);

				if (MediaTypeUri.getKeyByStringId(mediaTypeShortened) != null)
				{
					mediaTypeUri = MediaTypeUri.getKeyByStringId(
							mediaTypeShortened).getUri();
				}
			}
		}
		else
		{
			return null;
		}

		return mediaTypeUri;
	}

	public static void checkSignal(Model model, RDFContainer result,
			Resource signal)
	{
		if (!model.contains(ModelUtil.createStatement(model, result
				.getDescribedUri(), MO.encodes, signal)))
		{
			model.addStatement(result.getDescribedUri(), MO.encodes, signal);
			model.addStatement(signal, RDF.type, MO.Signal);
		}
	}

	public static void checkLyrics(Model model, Resource track, Resource lyrics)
	{
		if (!model.contains(ModelUtil.createStatement(model, track,
				MO.publication_of, lyrics)))
		{
			model.addStatement(track, MO.publication_of, lyrics);
			model.addStatement(lyrics, RDF.type, MO.Lyrics);
		}
	}

	public static void checkOriginalSignal(Model model, Resource signal,
			Resource originalSignal)
	{
		if (!model.contains(ModelUtil.createStatement(model, signal,
				MO.derived_from, originalSignal)))
		{
			model.addStatement(signal, MO.derived_from, originalSignal);
			model.addStatement(originalSignal, RDF.type, MO.Signal);
		}
	}

	public static void checkOriginalMusicalManifestation(Model model,
			Resource originalSignal, Resource originalMusicalManifestation)
	{
		if (!model.contains(ModelUtil.createStatement(model, originalSignal,
				FRBR.embodiment, originalMusicalManifestation)))
		{
			model.addStatement(originalSignal, FRBR.embodiment,
					originalMusicalManifestation);
			model.addStatement(originalMusicalManifestation, RDF.type,
					MO.MusicalManifestation);
		}
	}

	public static void checkOriginalLyrics(Model model,
			Resource originalMusicalManifestation, Resource originalLyrics)
	{
		if (!model.contains(ModelUtil
				.createStatement(model, originalMusicalManifestation,
						MO.publication_of, originalLyrics)))
		{
			model.addStatement(originalMusicalManifestation, MO.publication_of,
					originalLyrics);
			model.addStatement(originalLyrics, RDF.type, MO.Lyrics);
		}
	}

	public static void checkPerformance(Model model, Resource signal,
			Resource performance)
	{
		if (!model.contains(ModelUtil.createStatement(model, performance,
				MO.recorded_as, signal)))
		{
			model.addStatement(performance, MO.recorded_as, signal);
			model.addStatement(performance, RDF.type, MO.Performance);
		}
	}
}
