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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyGEOB;
import org.jaudiotagger.tag.id3.framebody.FrameBodyPCNT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyPOPM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTALB;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTBPM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCOM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCON;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCOP;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDAT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDRC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTENC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTEXT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTFLT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIT1;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIT2;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIT3;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTKEY;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTLAN;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTLEN;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTMED;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTMOO;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTOAL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTOFN;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTOLY;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTOPE;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTORY;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTOWN;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTPE1;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTPE2;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTPE3;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTPE4;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTPOS;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTPUB;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTRCK;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTRDA;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTRSN;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTRSO;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTSRC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTSSE;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTXXX;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTYER;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUFID;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUSLT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWCOM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWCOP;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWOAF;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWOAR;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWOAS;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWORS;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWPAY;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWPUB;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWXXX;
import org.ontoware.rdf2go.exception.ModelException;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.ontoware.rdf2go.vocabulary.RDF;
import org.ontoware.rdf2go.vocabulary.RDFS;
import org.ontoware.rdf2go.vocabulary.XSD;
import org.semanticdesktop.aperture.rdf.RDFContainer;
import org.semanticdesktop.aperture.rdf.util.ModelUtil;
import org.semanticdesktop.aperture.vocabulary.NIE;

import smiy.pmkb.util.Namespaces;
import smiy.pmkb.vocabulary.AO;
import smiy.pmkb.vocabulary.BIBO;
import smiy.pmkb.vocabulary.CO;
import smiy.pmkb.vocabulary.DC;
import smiy.pmkb.vocabulary.DCTERMS;
import smiy.pmkb.vocabulary.EVENT;
import smiy.pmkb.vocabulary.FOAF;
import smiy.pmkb.vocabulary.FRBR;
import smiy.pmkb.vocabulary.MO;
import smiy.pmkb.vocabulary.MT;
import smiy.pmkb.vocabulary.PBO;
import smiy.pmkb.vocabulary.PO;
import smiy.pmkb.vocabulary.TL;
import smiy.pmkb.vocabulary.WGS84;

/**
 * An enumeration of ID3v2 frames defined in the standards.
 */
public enum FrameIdentifier
{

	// the frames below have come from 2.3.0 and were kept in 2.4.0
	// they are common to both versions of the standard
	// http://www.id3.org/id3v2.4.0-frames

	AENC("Audio encryption", false), // FIXME: currently not supported by PMKB
	APIC("Attached picture", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyAPIC apic = (FrameBodyAPIC) body;
			Model model = result.getModel();
			Resource resource = ModelUtil.generateRandomResource(model);
			model.addStatement(resource, RDF.type, FOAF.Image);
			// FIXME: maybe remove the mime type information, if not really
			// needed
			if (apic.getMimeType() != null && apic.getMimeType().length() > 0)
			{
				model.addStatement(resource, NIE.mimeType, apic.getMimeType());
			}
			// FIXME: cover art can be item specific (as it is currently the
			// case)
			model.addStatement(result.getDescribedUri(), MO.image, resource);
		}
	},
	COMM("Comments", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			String description = ((FrameBodyCOMM) body).getDescription();
			Model model = result.getModel();
			boolean addDescription = (description != null && description
					.length() > 0);
			String text = ((FrameBodyCOMM) body).getText();
			boolean addText = (text != null && text.length() > 0);
			String resultString = (addDescription ? description : "")
					+ (addDescription && addText ? "\n" : "")
					+ (addText ? text : "");
			model.addStatement(resourceMap.get(ID3Util.TRACK), DC.description,
					ModelUtil.createLiteral(model, resultString));
			id3v1props.remove(DC.description);
		}
	},
	COMR("Commercial frame", false), // FIXME: currently not supported by PMKB
	ENCR("Encryption method registration", false), // FIXME: currently not
	// supported by
	// PMKB
	ETCO("Event timing codes", false), // FIXME: currently not supported by PMKB
	// (useful for music segmentation)
	GEOB("General encapsulated object", true), // FIXME: currently not supported
	// by
	// PMKB (this might be useful
	// for an embedded Semantic
	// Graph, which describes the
	// music document)
	/*
	 * GEOB("General encapsulated object", true) { public void
	 * process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2, HashMap<URI,
	 * String> id3v1props, RDFContainer result) { FrameBodyGEOB apic =
	 * (FrameBodyGEOB) body; Model model = result.getModel(); Resource resource
	 * = ModelUtil.generateRandomResource(model); model.addStatement(resource,
	 * RDF.type, NFO.Attachment); model.addStatement(resource, RDF.type,
	 * NIE.InformationElement); model.addStatement(result.getDescribedUri(),
	 * NID3.generalEncapsulatedObject, resource); // TODO, the FrameBodyGEOB
	 * class doesn't support mime types even // thought the specs indicate it
	 * should, this might change // in future versions of jaudiotagger and
	 * deserves to be // investigated } },
	 */
	GRID("Group identification registration", false), // FIXME: currently not
	// supported by PMKB
	LINK("Linked information", false), // FIXME: currently not supported by PMKB
	MCDI("Music CD identifier", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			// the jaudiotagger sucks, the FrameBodyMCDI doesn't have any
			// methods that would allow us to put anything interesting
			// with the NID3.musicCDIdentifier wtriple
		}
	}, // FIXME currently not supported by PMKB (information is binary
	// available)
	MLLT("MPEG location lookup table", false), // FIXME: currently not supported
	// by PMKB
	OWNE("Ownership frame", false), // FIXME: currently not supported by PMKB
	PRIV("Private frame", false), // FIXME: currently not supported by PMKB
	PCNT("Play counter", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyPCNT playcountFB = (FrameBodyPCNT) body;
			Model model = result.getModel();
			Resource playcounter = ModelUtil.generateRandomResource(model);
			model.addStatement(playcounter, RDF.type, PBO.PlayBackCounter);
			model.addStatement(playcounter, CO.count, ModelUtil.createLiteral(
					model, Integer.getInteger(
							Long.valueOf(playcountFB.getCounter()).toString())
							.intValue()));
			model.addStatement(playcounter, DC.title, ModelUtil.createLiteral(
					model, "ID3 Play counter"));
			model.addStatement(playcounter, PBO.media_object, resourceMap
					.get(ID3Util.TRACK));
		}
	}, // acts as general play counter
	POPM("Popularimeter", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyPOPM popularimeterFB = (FrameBodyPOPM) body;
			Model model = result.getModel();
			Resource popularimeter = ModelUtil.generateRandomResource(model);
			model.addStatement(popularimeter, RDF.type, PBO.PlayBackCounter);
			model.addStatement(popularimeter, CO.count, ModelUtil
					.createLiteral(model, Integer.getInteger(
							Long.valueOf(popularimeterFB.getCounter())
									.toString()).intValue()));
			model.addStatement(popularimeter, DC.title, ModelUtil
					.createLiteral(model, "ID3 Play counter"));

			Resource person = ModelUtil.generateRandomResource(model);
			model.addStatement(person, RDF.type, FOAF.Person);
			model.addStatement(person, FOAF.mbox, new URIImpl("mailto:"
					+ popularimeterFB.getEmailToUser()));

			// popularimeter is currently related with the item
			model.addStatement(popularimeter, PBO.media_object, result
					.getDescribedUri());
		}
	}, // acts as personal play counter; that means, multiple POPM frames can
	// exist in one ID3 tag (the rating parameter isn't currently handled)
	POSS("Position synchronisation frame", false), // FIXME: currently not
	// supported by PMKB
	RBUF("Recommended buffer size", false), // FIXME: currently not supported by
	// PMKB
	RVRB("Reverb", false), // FIXME: currently not supported by PMKB
	SYLT("Synchronised lyric/text", false), // incorporating the words, said or
	// sung lyrics, in the audio file as
	// text, in sync with the audio;
	// FIXME: currently not supported by
	// PMKB
	SYTC("Synchronised tempo codes", false), // For a more accurate description
	// of the tempo of a musical
	// piece; FIXME: currently not
	// supported by PMKB
	TALB("Album/Movie/Show title", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTALB albumTitleFB = (FrameBodyTALB) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.addStringLiteral(model,
					resourceMap.get(ID3Util.MUSICALBUM), DC.title, albumTitleFB
							.getFirstTextValue());

			id3v1props.remove(NID3.albumTitle);
		}
	},
	TBPM("BPM (beats per minute)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTBPM bpmFB = (FrameBodyTBPM) body;

			Model model = result.getModel();

			ID3Util.checkBPM(model, resourceMap, Float.valueOf(
					bpmFB.getFirstTextValue()).floatValue());
		}
	},
	TCOM("Composer", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTCOM composerFB = (FrameBodyTCOM) body;
			Model model = result.getModel();

			// I use here currently frbr:subject, maybe a proper (inverse)
			// relation, e.g. mo:musical_work, might be better
			// FIXME: currently it is a work to item relation
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALWORK), FRBR.subject, result
					.getDescribedUri(), MO.MusicalWork);

			// relate the musical work to its composition event
			Resource composition = ModelUtil.generateRandomResource(model);
			model.addStatement(resourceMap.get(ID3Util.MUSICALWORK),
					MO.composed_in, composition);
			model.addStatement(composition, RDF.type, MO.Composition);

			// relate the composition event to its composer
			ID3Util.addAgent(model, composition, MO.composer, MO.Composer,
					composerFB.getFirstTextValue());
		}
	},
	TCON("Content type", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			String value = ((FrameBodyTCON) body).getFirstTextValue();

			Model model = result.getModel();
			// the ID3V2 specs allow for the use of ID3V1 genre identifiers but
			// they need to be enclosed in brackets
			// we disregard multiple genres (take only the first one) and the
			// extensions (completely)\
			boolean ok = false;
			if (value.startsWith("("))
			{
				int end = value.indexOf(')');
				if (end != -1)
				{
					String integerString = value.substring(1, end);
					try
					{
						int intValue = Integer.parseInt(integerString);
						GenreUri genreUri = GenreUri
								.getGenreUriByIntId(intValue);
						if (genreUri != null)
						{
							// FIXME: a music genre can also be item specific
							// (subjective, personal)
							model.addStatement(resourceMap.get(ID3Util.TRACK),
									MO.genre, genreUri.getUri());
							ok = true;
						}
					}
					catch (NumberFormatException nfe)
					{
						// do nothing, that's not a problem, the boolean ok var
						// will stay false and the string will
						// be inserted into the result RDFContainer as it is
					}
				}
			}
			// if there were any problems with translating the value like (13)
			// or (13)Pop or (13)(45) into "Pop"
			// leave it as it is
			if (!ok)
			{
				// introduce a new URI for a new music genre
				// TODO: write a proper music genre instantiation (with
				// duplicate check etc)
				// a music genre can also be item specific (subjective,
				// personal)
				model.addStatement(resourceMap.get(ID3Util.TRACK), MO.genre,
						new URIImpl(Namespaces.PMKB_NS + GenreUri.GENRE_RURI
								+ value));
			}
			id3v1props.remove(NID3.contentType);
		}
	}, // FIXME: enable multiple music genre detection
	TCOP("Copyright message", false), // the content of this frame is very
	// ambiguous; FIXME: currently not
	// supported by PMKB
	TDLY("Playlist delay", false), // why do we need such information in an ID3
	// tag? - it depends to a playlist
	// description!; FIXME: currently not
	// supported by PMKB
	TENC("Encoded by", false), // the content of this frame is very ambiguous;
	// FIXME: currently not supported by PMKB
	TEXT("Lyricist/Text writer", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTEXT lyricistFB = (FrameBodyTEXT) body;
			Model model = result.getModel();

			ID3Util.checkStatementObject(model, resourceMap.get(ID3Util.TRACK),
					MO.publication_of, resourceMap.get(ID3Util.LYRICS),
					MO.Lyrics);

			ID3Util.addAgent(model, resourceMap.get(ID3Util.LYRICS),
					DCTERMS.creator, FOAF.Person, lyricistFB
							.getFirstTextValue());
		}
	},
	TFLT("File type", false), // some types are predefined, although, further
	// values are possible; FIXME: currently not
	// supported by PMKB
	TIT1("Content group description", false), // the content of this frame is
	// very ambiguous; FIXME:
	// currently not supported by
	// PMKB
	TIT2("Title/songname/content description", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			Model model = result.getModel();
			FrameBodyTIT2 titleFB = (FrameBodyTIT2) body;

			// FIXME: a title can also be item specific (subjective, personal)
			// -> this is currently the case
			model.addStatement(result.getDescribedUri(), DC.title, ModelUtil
					.createLiteral(model, titleFB.getFirstTextValue()));
			id3v1props.remove(DC.title);
		}
	},
	TIT3("Subtitle/Description refinement", false), // the content of this frame
	// is very ambiguous; FIXME:
	// currently not supported
	// by PMKB
	TKEY("Initial key", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTKEY keyFB = (FrameBodyTKEY) body;
			if (keyFB.isValid())
			{
				Model model = result.getModel();

				// relate to master signal
				ID3Util.checkStatementSubject(model, resourceMap
						.get(ID3Util.SIGNAL), MO.published_as, resourceMap
						.get(ID3Util.TRACK), MO.Signal);

				model.addStatement(resourceMap.get(ID3Util.SIGNAL), MO.key,
						KeyUri.getKeyByStringId(keyFB.getFirstTextValue())
								.getUri());
			}
		}
	},
	TLAN("Language(s)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTLAN languageFB = (FrameBodyTLAN) body;
			if (languageFB.isValid())
			{
				Model model = result.getModel();

				ID3Util.checkStatementObject(model, resourceMap
						.get(ID3Util.TRACK), MO.publication_of, resourceMap
						.get(ID3Util.LYRICS), MO.Lyrics);

				// TODO: we have to store the ISO-639-2 based language tag(s) as
				// language tag of the lyrics string; that means, we first need
				// the lyrics to append the language tag; ISO-639-2 should be a
				// part of IETF BCP 47
				lyricsLanguage = languageFB.getFirstTextValue();
			}
		}
	},
	TLEN("Length", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTLEN lengthFB = (FrameBodyTLEN) body;

			Model model = result.getModel();

			// relate to audio file signal
			ID3Util.checkStatementObject(model, result.getDescribedUri(),
					MO.encodes, resourceMap.get(ID3Util.SIGNAL), MO.Signal);

			Resource timeInterval = ModelUtil.generateRandomResource(model);
			model.addStatement(timeInterval, RDF.type,
					smiy.pmkb.vocabulary.TIME.Interval);
			model.addStatement(timeInterval, TL.durationInt, ModelUtil
					.createLiteral(model, Integer.parseInt(lengthFB
							.getFirstTextValue())));
			model.addStatement(resourceMap.get(ID3Util.SIGNAL), MO.time,
					timeInterval);
		}
	},
	TMED("Media type", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			if (ID3Util.getMediaType((AbstractFrameBodyTextInfo) body) != null)
			{
				Model model = result.getModel();

				// relate to master signal
				ID3Util.checkStatementSubject(model, resourceMap
						.get(ID3Util.SIGNAL), MO.published_as, resourceMap
						.get(ID3Util.TRACK), MO.Signal);
				ID3Util.checkStatementObject(model, resourceMap
						.get(ID3Util.SIGNAL), MO.derived_from, resourceMap
						.get(ID3Util.ORIGINALSIGNAL), MO.Signal);
				ID3Util.checkStatementObject(model, resourceMap
						.get(ID3Util.ORIGINALSIGNAL), FRBR.embodiment,
						resourceMap.get(ID3Util.ORIGINALMUSICALMANIFESTATION),
						MO.MusicalManifestation);

				model
						.addStatement(
								resourceMap
										.get(ID3Util.ORIGINALMUSICALMANIFESTATION),
								MO.media_type,
								ID3Util
										.getMediaType((AbstractFrameBodyTextInfo) body));
			}
		}
	}, // describes from which media the sound originated
	TOAL("Original album/movie/show title", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			Model model = result.getModel();
			FrameBodyTOAL originalTitleFB = (FrameBodyTOAL) body;

			// relate to master signal
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);
			ID3Util.checkStatementObject(model,
					resourceMap.get(ID3Util.SIGNAL), MO.derived_from,
					resourceMap.get(ID3Util.ORIGINALSIGNAL), MO.Signal);
			ID3Util.checkStatementObject(model, resourceMap
					.get(ID3Util.ORIGINALSIGNAL), FRBR.embodiment, resourceMap
					.get(ID3Util.ORIGINALMUSICALMANIFESTATION),
					MO.MusicalManifestation);

			model.addStatement(resourceMap
					.get(ID3Util.ORIGINALMUSICALMANIFESTATION), DC.title,
					ModelUtil.createLiteral(model, originalTitleFB
							.getFirstTextValue()));
		}
	},
	TOFN("Original filename", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			result.add(NID3.originalFilename, ((FrameBodyTOFN) body)
					.getFirstTextValue());
		}
	}, // contains the preferred filename for the file, since some media doesn't
	// allow the desired length of the filename; FIXME: this statement uses
	// currently a NID3 term
	TOLY("Original lyricist(s)/text writer(s)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTOLY originalLyricistFB = (FrameBodyTOLY) body;
			Model model = result.getModel();

			// relate to master signal
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);
			ID3Util.checkStatementObject(model,
					resourceMap.get(ID3Util.SIGNAL), MO.derived_from,
					resourceMap.get(ID3Util.ORIGINALSIGNAL), MO.Signal);
			ID3Util.checkStatementObject(model, resourceMap
					.get(ID3Util.ORIGINALSIGNAL), FRBR.embodiment, resourceMap
					.get(ID3Util.ORIGINALMUSICALMANIFESTATION),
					MO.MusicalManifestation);
			ID3Util.checkStatementObject(model, resourceMap
					.get(ID3Util.ORIGINALMUSICALMANIFESTATION),
					MO.publication_of, resourceMap.get(ID3Util.ORIGINALLYRICS),
					MO.Lyrics);

			ID3Util.addAgent(model, resourceMap.get(ID3Util.ORIGINALLYRICS),
					DCTERMS.creator, FOAF.Person, originalLyricistFB
							.getFirstTextValue());
		}
	},
	TOPE("Original artist(s)/performer(s)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTOPE originalArtistFB = (FrameBodyTOPE) body;
			Model model = result.getModel();

			// relate to master signal
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);
			ID3Util.checkStatementObject(model,
					resourceMap.get(ID3Util.SIGNAL), MO.derived_from,
					resourceMap.get(ID3Util.ORIGINALSIGNAL), MO.Signal);

			// FIXME: handle multiple artists/performers ("/" separated)
			ID3Util.addAgent(model, resourceMap.get(ID3Util.ORIGINALSIGNAL),
					DCTERMS.creator, MO.MusicArtist, originalArtistFB
							.getFirstTextValue());
		}
	},
	TOWN("File owner/licensee", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTOWN ownerFB = (FrameBodyTOWN) body;
			Model model = result.getModel();

			// frbr:owner (on item level (?))
			ID3Util.addAgent(model, result.getDescribedUri(), FRBR.owner,
					FOAF.Person, ownerFB.getFirstTextValue());
		}
	},
	TPE1("Lead performer(s)/Soloist(s)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTPE1 soloistFB = (FrameBodyTPE1) body;
			Model model = result.getModel();

			// FIXME: handle multiple soloists/lead performers ("/" separated)
			// and mark them somehow explicitly
			ID3Util.checkArtist(model, soloistFB.getFirstTextValue(),
					resourceMap.get(ID3Util.TRACK));
			id3v1props.remove(NID3.leadArtist);
		}
	},
	TPE2("Band/orchestra/accompaniment", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTPE2 bandFB = (FrameBodyTPE2) body;
			Model model = result.getModel();

			// FIXME: handle multiple bands/orchestras/accompaniments ("/"
			// separated ?)
			// and mark them somehow explicitly
			ID3Util.checkArtist(model, bandFB.getFirstTextValue(), resourceMap
					.get(ID3Util.TRACK));
		}
	},
	TPE3("Conductor/performer refinement", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTPE3 conductorFB = (FrameBodyTPE3) body;
			Model model = result.getModel();

			// relate to master signal
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.PERFORMANCE), MO.recorded_as, resourceMap
					.get(ID3Util.SIGNAL), MO.Performance);

			ID3Util.addAgent(model, resourceMap.get(ID3Util.PERFORMANCE),
					MO.conductor, FOAF.Person, conductorFB.getFirstTextValue());
		}
	},
	TPE4("Interpreted, remixed, or otherwise modified by", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTPE4 interpreterFB = (FrameBodyTPE4) body;
			Model model = result.getModel();

			// relate to master signal
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);

			ID3Util.addAgent(model, resourceMap.get(ID3Util.SIGNAL),
					MO.interpreter, MO.MusicArtist, interpreterFB
							.getFirstTextValue());
		}
	},
	TPOS("Part of a set", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTPOS positionFB = (FrameBodyTPOS) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);

			// FIXME: may surround this with some try and catch, to avoid null
			// pointer exceptions
			model.addStatement(resourceMap.get(ID3Util.MUSICALBUM),
					MO.record_number, ModelUtil.createLiteral(model, positionFB
							.getDiscNo().intValue()));
			ID3Util.checkCount(model, resourceMap.get(ID3Util.RELEASE),
					MO.record_count, positionFB.getDiscTotal().intValue());
		}
	},
	TPUB("Publisher", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTPUB publisherFB = (FrameBodyTPUB) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASEEVENT), MO.release, resourceMap
					.get(ID3Util.RELEASE), MO.ReleaseEvent);

			// FIXME: associates publisher explicitly as label, however it can
			// also be a person
			ID3Util.addAgent(model, resourceMap.get(ID3Util.RELEASEEVENT),
					MO.label, MO.Label, publisherFB.getFirstTextValue());
		}
	},
	TRCK("Track number/Position in set", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTRCK trackNumberFB = (FrameBodyTRCK) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);

			// FIXME: may surround this with some try and catch, to avoid null
			// pointer exceptions
			model.addStatement(resourceMap.get(ID3Util.TRACK), MO.track_number,
					ModelUtil.createLiteral(model, trackNumberFB.getTrackNo()
							.intValue()));
			ID3Util.checkCount(model, resourceMap.get(ID3Util.MUSICALBUM),
					MO.track_count, trackNumberFB.getTrackTotal().intValue());
		}
	},
	TRSN("Internet radio station name", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTRSN internetRadioStationNameFB = (FrameBodyTRSN) body;
			Model model = result.getModel();

			ID3Util.checkStream(model, result, resourceMap);
			ID3Util.prepareServiceOutletConnection(model, resourceMap);

			// add internet radion station name
			model.addStatement(resourceMap.get(ID3Util.OUTLET), DC.title,
					ModelUtil.createLiteral(model, internetRadioStationNameFB
							.getFirstTextValue()));
		}
	},
	TRSO("Internet radio station owner", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTRSO internetRadioStationOwnerFB = (FrameBodyTRSO) body;
			Model model = result.getModel();

			ID3Util.checkStream(model, result, resourceMap);
			ID3Util.prepareServiceOutletConnection(model, resourceMap);

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SERVICE), PO.outlet, resourceMap
					.get(ID3Util.OUTLET), PO.Service);

			// add broadcaster
			ID3Util.addAgent(model, resourceMap.get(ID3Util.SERVICE),
					PO.broadcaster, PO.Broadcaster, internetRadioStationOwnerFB
							.getFirstTextValue());
		}
	},
	TSRC("ISRC (international standard recording code)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTSRC isrcFB = (FrameBodyTSRC) body;
			Model model = result.getModel();

			// relate to master signal
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);

			model.addStatement(resourceMap.get(ID3Util.SIGNAL), MO.isrc,
					ModelUtil.createLiteral(model, isrcFB.getFirstTextValue()));
		}
	},
	TSSE("Software/Hardware and settings used for encoding", false), // FIXME:
	// currently
	// not
	// supported
	// by
	// PMKB
	TXXX("User defined text information frame", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			String description = txxx.getDescription();
			UserDefinedDescription userDefinedDescription = UserDefinedDescription
					.getDescriptionByStringId(description);
			userDefinedDescription.process(body, result, resourceMap);
		}
	},
	UFID("Unique file identifier", false), // FIXME: currently not supported by
	// PMKB
	USER("Terms of use", false), // contains a brief description of the terms of
	// use and ownership of the file; FIXME:
	// currently not supported by PMKB
	USLT("Unsynchronised lyric/text transcription", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyUSLT lyricsFB = (FrameBodyUSLT) body;
			Model model = result.getModel();

			ID3Util.checkStatementObject(model, resourceMap.get(ID3Util.TRACK),
					MO.publication_of, resourceMap.get(ID3Util.LYRICS),
					MO.Lyrics);

			// FIXME: what about lyricsLanguage from TLAN? how to handle
			// multiple lyric texts?
			model.addStatement(resourceMap.get(ID3Util.LYRICS), MO.text,
					lyricsFB.getFirstTextValue(), lyricsFB.getLanguage());
		}
	},
	WCOM("Commercial information", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWCOM commercialInformationFB = (FrameBodyWCOM) body;
			Model model = result.getModel();

			// a URL pointing at a webpage with information such as where the
			// album can be bought
			Resource commercialInformation = model
					.createURI(commercialInformationFB.getUrlLink());
			model.addStatement(commercialInformation, FOAF.primaryTopic,
					resourceMap.get(ID3Util.TRACK));
			model.addStatement(commercialInformation, RDF.type, BIBO.Document);
		}
	},
	WCOP("Copyright/Legal information", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWCOP copyrightFB = (FrameBodyWCOP) body;
			Model model = result.getModel();

			// use mo:licence for the moment
			Resource copyright = model.createURI(copyrightFB.getUrlLink());
			model.addStatement(resourceMap.get(ID3Util.TRACK), MO.licence,
					copyright);
			model.addStatement(copyright, RDF.type, BIBO.Document);
		}
	},
	WOAF("Official audio file webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWOAF fileSiteFB = (FrameBodyWOAF) body;
			Model model = result.getModel();

			// FIXME: a file (!) specific webpage? - currently track specific
			// webpage
			Resource fileSite = model.createURI(fileSiteFB.getUrlLink());
			model.addStatement(fileSite, FOAF.primaryTopic, resourceMap
					.get(ID3Util.TRACK));
			model.addStatement(fileSite, RDF.type, BIBO.Document);
		}
	},
	WOAR("Official artist/performer webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWOAR) body).getUrlLink());
			result.add(NID3.officialArtistWebpage, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	}, // very unspecific, because this frame can also exist multiple times, so
		// how should one associate the correct artist to the correct webpage?
	WOAS("Official audio source webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWOAS) body).getUrlLink());
			result.add(NID3.officialAudioSourceWebpage, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	},
	WORS("Official Internet radio station homepage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWORS) body).getUrlLink());
			result.add(NID3.officialInternetRadioStationHomepage, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	},
	WPAY("Payment", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWPAY) body).getUrlLink());
			result.add(NID3.paymentURL, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	},
	WPUB("Publishers official webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWPUB) body).getUrlLink());
			result.add(NID3.publishersWebpage, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	},
	WXXX("User defined URL link frame", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWXXX txxx = (FrameBodyWXXX) body;
			String description = txxx.getDescription();
			String text = txxx.getUrlLink();
			Model model = result.getModel();
			Resource resource = ModelUtil.generateRandomResource(model);
			model.addStatement(resource, RDF.type, NID3.UserDefinedURLFrame);
			model.addStatement(resource, NID3.userDefinedFrameDescription,
					description);
			model.addStatement(resource, NID3.userDefinedFrameValue, text);
			model.addStatement(result.getDescribedUri(), NID3.userDefinedFrame,
					resource);
		}
	},

	// these frames are new, they appeared in the 2.4.0 version of the standard
	// http://www.id3.org/id3v2.4.0-changes
	ASPI("Audio seek point index", false), // not supported by NID3
	EQU2("Equalisation (2)", false), // not supported by NID3
	RVA2("Relative volume adjustment (2)", false), // not supported by NID3
	SEEK("Seek frame", false), // not supported by NID3
	SIGN("Signature frame", false), // not supported by NID3
	TDEN("Encoding time", false), // not supported by NID3
	TDOR("Original release time", false), // not supported by NID3
	TDRC("Recording time", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTDRC tdrc = (FrameBodyTDRC) body;
			Date date = id3v24timestampToDate(tdrc.getFirstTextValue());
			result.add(NID3.date, date);
		}
	},
	TDRL("Release time", false), // not supported by NID3
	TDTG("Tagging time", false), // not supported by NID3
	TIPL("Involved people list", false), // not supported by NID3
	TMCL("Musician credits list", false), // not supported by NID3
	TMOO("Mood", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTMOO moodFB = (FrameBodyTMOO) body;
			Model model = result.getModel();

			// relate to master signal
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);

			ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.SIGNAL),
					AO.mood, moodFB.getFirstTextValue());
		}
	},
	TPRO("Produced notice", false), // not supported by NID3
	TSOA("Album sort order", false), // not supported by NID3
	TSOP("Performer sort order", false), // not supported by NID3
	TSOT("Title sort order", false), // not supported by NID3
	TSST("Set subtitle", false), // not supported by NID3

	// these frames were present in ID3 v 2.3.0, but have been deprecated in
	// 2.4.0 see: http://www.id3.org/id3v2.4.0-changes

	/** This frame is replaced by the EQU2 frame, 'Equalisation (2)' [F:4.12]. */
	EQUA("Equalization", false), // not supported by NID3
	/**
	 * This frame is replaced by the two frames TMCL, 'Musician credits list'
	 * [F:4.2.2], and TIPL, 'Involved people list' [F:4.2.2].
	 */
	IPLS("Involved people list", false), // not supported by NID3
	/**
	 * This frame is replaced by the RVA2 frame, 'Relative volume adjustment
	 * (2)' [F:4.11].
	 */
	RVAD("Relative volume adjustment", false), // not supported by NID3
	/** This frame is replaced by the TDRC frame, 'Recording time' [F:4.2.5]. */
	TDAT("Date", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTDAT tdat = (FrameBodyTDAT) body;
			String text = tdat.getFirstTextValue();
			// we only support well-formed dates
			if (text.length() == 4)
			{
				try
				{
					int day = Integer.parseInt(text.substring(0, 2));
					// months in a gregorian calendar a 0-based (0 is january)
					int month = Integer.parseInt(text.substring(2, 4)) - 1;
					// we must add the year to make the date complete
					String yearString = id3v2.getFirst(TYER.toString());
					if (yearString.length() > 0)
					{
						int year = Integer.parseInt(yearString);
						String time = id3v2.getFirst(TIME.toString());
						if (time.length() > 0)
						{
							int hour = Integer.parseInt(text.substring(0, 2));
							int minute = Integer.parseInt(text.substring(2, 4));
							Calendar calendar = new GregorianCalendar(year,
									month, day, hour, minute);
							result.add(NID3.date, calendar.getTime());
						}
						else
						{
							Calendar calendar = new GregorianCalendar(year,
									month, day);
							result.add(NID3.date, calendar.getTime());
						}
					}
				}
				catch (Exception e)
				{
					// a pity, something went wrong, we discard these cases
					// most probably these are NumberFormatExceptions which
					// in turn indicate a corrupted MP3 file
				}
			}
		}
	},
	/** This frame is replaced by the TDRC frame, 'Recording time' [F:4.2.5]. */
	TIME("Time", false), // this is covered by the TDAT frame, NID3 doesn't have
	// any properties that would allow for simple xsd:time
	// values to be stored
	/**
	 * This frame is replaced by the TDOR frame, 'Original release time'
	 * [F:4.2.5].
	 */
	TORY("Original release year", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			result.add(NID3.originalReleaseYear, result.getModel()
					.createDatatypeLiteral(
							((FrameBodyTORY) body).getFirstTextValue(),
							XSD._integer));
		}
	},
	/** This frame is replaced by the TDRC frame, 'Recording time' [F:4.2.5]. */
	TRDA("Recording dates", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			result.add(NID3.recordingDate, ((FrameBodyTRDA) body)
					.getFirstTextValue());
		}
	},
	/**
	 * The information contained in this frame is in the general case either
	 * trivial to calculate for the player or impossible for the tagger to
	 * calculate. There is however no good use for such information. The frame
	 * is therefore completely deprecated.
	 */
	TSIZ("Size", false), // not supported by NID3
	/** This frame is replaced by the TDRC frame, 'Recording time' [F:4.2.5]. */
	TYER("Year", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			result.add(NID3.recordingYear, result.getModel()
					.createDatatypeLiteral(
							((FrameBodyTYER) body).getFirstTextValue(),
							XSD._integer));
			id3v1props.remove(NID3.recordingYear);
		}
	},

	// and these are the frames defined in ID3 2.2.0 standard, they used
	// 3-letter codes
	// they are now obsolete, but files with those frames do still occur

	BUF("Recommended buffer size", false), CNT("Play counter", false), COM(
			"Comments", false), CRA("Audio encryption", false), CRM(
			"Encrypted meta frame", false), ETC("Event timing codes", false), EQU(
			"Equalization", false), GEO("General encapsulated object", false), IPL(
			"Involved people list", false), LNK("Linked information", false), MCI(
			"Music CD Identifier", false), MLL("MPEG location lookup table",
			false), PIC("Attached picture", false), POP("Popularimeter", false), REV(
			"Reverb", false), RVA("Relative volume adjustment", false), SLT(
			"Synchronized lyric/text", false), STC("Synced tempo codes", false), TAL(
			"Album/Movie/Show title", false), TBP("BPM (Beats Per Minute)",
			false), TCM("Composer", false), TCO("Content type", false), TCR(
			"Copyright message", false), TDA("Date", false), TDY(
			"Playlist delay", false), TEN("Encoded by", false), TFT(
			"File type", false), TIM("Time", false), TKE("Initial key", false), TLA(
			"Language(s)", false), TLE("Length", false), TMT("Media type",
			false), TOA("Original artist(s)/performer(s)", false), TOF(
			"Original filename", false), TOL(
			"Original Lyricist(s)/text writer(s)", false), TOR(
			"Original release year", false), TOT(
			"Original album/Movie/Show title", false), TP1(
			"Lead artist(s)/Lead performer(s)/Soloist(s)/Performing group",
			false), TP2("Band/Orchestra/Accompaniment", false), TP3(
			"Conductor/Performer refinement", false), TP4(
			"Interpreted, remixed, or otherwise modified by", false), TPA(
			"Part of a set", false), TPB("Publisher", false), TRC(
			"ISRC (International Standard Recording Code)", false), TRD(
			"Recording dates", false), TRK("Track number/Position in set",
			false), TSI("Size", false), TSS(
			"Software/hardware and settings used for encoding", false), TT1(
			"Content group description", false), TT2(
			"Title/Songname/Content description", false), TT3(
			"Subtitle/Description refinement", false), TXT(
			"Lyricist/text writer", false), TXX(
			"User defined text information frame", false), TYE("Year", false), UFI(
			"Unique file identifier", false), ULT(
			"Unsychronized lyric/text transcription", false), WAF(
			"Official audio file webpage", false), WAR(
			"Official artist/performer webpage", false), WAS(
			"Official audio source webpage", false), WCM(
			"Commercial information", false), WCP(
			"Copyright/Legal information", false), WPB(
			"Publishers official webpage", false), WXX(
			"User defined URL link frame", false);

	private String name;
	private boolean isSupported;
	private static String lyricsLanguage;

	FrameIdentifier(String name, boolean isSupported)
	{
		this.name = name;
		this.isSupported = isSupported;
	}

	public String getName()
	{
		return name;
	}

	public boolean isSupported()
	{
		return isSupported;
	}

	public String getLyricsLanguage()
	{
		return lyricsLanguage;
	}

	public void setLyricsLanguage(String ll)
	{
		lyricsLanguage = ll;
	}

	public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
			HashMap<URI, String> id3v1props, RDFContainer result,
			HashMap<String, Resource> resourceMap)
	{
		// the default behavior for unsupported frames is to do nothing
	}
}
