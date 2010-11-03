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
import java.util.List;

import org.jaudiotagger.tag.datatype.Pair;
import org.jaudiotagger.tag.datatype.PairedTextEncodedStringNullTerminated.ValuePairs;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyPCNT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyPOPM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTALB;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTBPM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCOM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCON;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDAT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDEN;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDOR;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDRC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDRL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTEXT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIPL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIT2;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTKEY;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTLAN;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTLEN;
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
import org.jaudiotagger.tag.id3.framebody.FrameBodyTRSN;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTRSO;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTSRC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTXXX;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTYER;
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
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.ontoware.rdf2go.vocabulary.RDF;
import org.semanticdesktop.aperture.rdf.RDFContainer;
import org.semanticdesktop.aperture.rdf.util.ModelUtil;
import org.semanticdesktop.aperture.vocabulary.NID3;
import org.semanticdesktop.aperture.vocabulary.NIE;

import smiy.pmkb.util.Namespaces;
import smiy.pmkb.vocabulary.AO;
import smiy.pmkb.vocabulary.BIBO;
import smiy.pmkb.vocabulary.DC;
import smiy.pmkb.vocabulary.DCTERMS;
import smiy.pmkb.vocabulary.FOAF;
import smiy.pmkb.vocabulary.FRBR;
import smiy.pmkb.vocabulary.MO;
import smiy.pmkb.vocabulary.PO;
import smiy.pmkb.vocabulary.TL;

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
			ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.TRACK),
					DC.description, resultString);
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

			ID3Util.createPlayCounter(model, Integer.getInteger(
					Long.valueOf(playcountFB.getCounter()).toString())
					.intValue(), "ID3 play counter", resourceMap
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

			// popularimeter is currently related with the item
			ID3Util.createPlayCounter(model, Integer.getInteger(
					Long.valueOf(popularimeterFB.getCounter()).toString())
					.intValue(), "personal play counter", result
					.getDescribedUri());

			Resource person = ModelUtil.generateRandomResource(model);
			model.addStatement(person, RDF.type, FOAF.Person);
			model.addStatement(person, FOAF.mbox, new URIImpl("mailto:"
					+ popularimeterFB.getEmailToUser()));
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
			ID3Util.addStringLiteral(model, result.getDescribedUri(), DC.title,
					titleFB.getFirstTextValue());

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

				// relate to "master signal"
				ID3Util.checkStatementSubject(model, resourceMap
						.get(ID3Util.MASTERSIGNAL), MO.published_as,
						resourceMap.get(ID3Util.TRACK), MO.Signal);

				model.addStatement(resourceMap.get(ID3Util.MASTERSIGNAL),
						MO.key, KeyUri.getKeyByStringId(
								keyFB.getFirstTextValue()).getUri());
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
			ID3Util.addIntegerLiteral(model, timeInterval, TL.durationInt,
					Integer.parseInt(lengthFB.getFirstTextValue()));
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

				// relate to "master signal"
				ID3Util.checkStatementSubject(model, resourceMap
						.get(ID3Util.MASTERSIGNAL), MO.published_as,
						resourceMap.get(ID3Util.TRACK), MO.Signal);
				ID3Util.checkStatementObject(model, resourceMap
						.get(ID3Util.MASTERSIGNAL), MO.derived_from,
						resourceMap.get(ID3Util.ORIGINALSIGNAL), MO.Signal);
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

			ID3Util.prepareOriginalMusicalManifestation(model, resourceMap);

			ID3Util.addStringLiteral(model, resourceMap
					.get(ID3Util.ORIGINALMUSICALMANIFESTATION), DC.title,
					originalTitleFB.getFirstTextValue());

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

			ID3Util.prepareOriginalMusicalManifestation(model, resourceMap);
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

			// relate to "master signal"
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);
			ID3Util.checkStatementObject(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.derived_from, resourceMap
					.get(ID3Util.ORIGINALSIGNAL), MO.Signal);

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
			ID3Util.checkStatementObject(model, resourceMap.get(ID3Util.TRACK),
					DCTERMS.creator, resourceMap.get(ID3Util.TRACKARTIST),
					MO.MusicArtist);
			ID3Util.addStringLiteral(model, resourceMap
					.get(ID3Util.TRACKARTIST), FOAF.name, soloistFB
					.getFirstTextValue());
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

			// relate to "master signal"
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.PERFORMANCE), MO.recorded_as, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.Performance);

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

			// relate to "master signal"
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);

			ID3Util.addAgent(model, resourceMap.get(ID3Util.MASTERSIGNAL),
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
			ID3Util.addIntegerLiteral(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.record_number, positionFB
					.getDiscNo().intValue());
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

			ID3Util.preparePublisherConnection(model, resourceMap);

			ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.LABEL),
					FOAF.name, publisherFB.getFirstTextValue());
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
			ID3Util.addIntegerLiteral(model, resourceMap.get(ID3Util.TRACK),
					MO.track_number, trackNumberFB.getTrackNo().intValue());
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
			ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.OUTLET),
					DC.title, internetRadioStationNameFB.getFirstTextValue());
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

			// relate to "master signal"
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);

			ID3Util.addStringLiteral(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.isrc, isrcFB
					.getFirstTextValue());
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
			// FIXME: I used mo:paid_download for WPAY :\
			// if its not the homepage, then it is "just" a page
			ID3Util.createPageLink(model, commercialInformationFB.getUrlLink(),
					resourceMap.get(ID3Util.TRACK), FOAF.page);
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
			ID3Util.createPageLink(model, fileSiteFB.getUrlLink(), resourceMap
					.get(ID3Util.TRACK), FOAF.homepage);
		}
	},
	WOAR("Official artist/performer webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWOAR artistSiteFB = (FrameBodyWOAR) body;
			Model model = result.getModel();

			ID3Util.checkStatementObject(model, resourceMap.get(ID3Util.TRACK),
					DCTERMS.creator, resourceMap.get(ID3Util.TRACKARTIST),
					MO.MusicArtist);

			// FIXME: how should I know, which artist webpage belongs to which
			// artist? - currently I add these page to one (!) track artist :\
			ID3Util.createPageLink(model, artistSiteFB.getUrlLink(),
					resourceMap.get(ID3Util.TRACKARTIST), FOAF.homepage);
		}
	}, // very unspecific, because this frame can also exist multiple times, so
	// how should one associate the correct artist to the correct webpage?
	WOAS("Official audio source webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWOAS sourceSiteFB = (FrameBodyWOAS) body;
			Model model = result.getModel();

			// FIXME: a URL pointing at the official webpage for the source of
			// the
			// audio file, e.g. a movie (?) - we do not have a URI for the
			// source :\
			Resource sourceSite = model.createURI(sourceSiteFB.getUrlLink());
			// only foaf:topic here!
			model.addStatement(sourceSite, FOAF.topic, resourceMap
					.get(ID3Util.TRACK));
			model.addStatement(sourceSite, RDF.type, BIBO.Document);

			Resource source = ModelUtil.generateRandomResource(model);
			// dcterms:subject (dcterms:source is not really appropriated,
			// because "...derived from ...")
			model.addStatement(source, DCTERMS.subject, resourceMap
					.get(ID3Util.TRACK));
			// primary topic of the source site!
			model.addStatement(sourceSite, FOAF.primaryTopic, source);
			// we don't know at this moment, which type the source is of
			model.addStatement(source, RDF.type,
					org.ontoware.rdf2go.vocabulary.OWL.Thing);
			// if its not the homepage, then it is "just" a page
			model.addStatement(resourceMap.get(ID3Util.TRACK), FOAF.page,
					sourceSite);
		}
	},
	WORS("Official Internet radio station homepage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWORS internetRadioStationSiteFB = (FrameBodyWORS) body;
			Model model = result.getModel();

			ID3Util.checkStream(model, result, resourceMap);
			ID3Util.prepareServiceOutletConnection(model, resourceMap);

			ID3Util.createPageLink(model, internetRadioStationSiteFB
					.getUrlLink(), resourceMap.get(ID3Util.OUTLET),
					FOAF.homepage);
		}
	},
	WPAY("Payment", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWPAY paymentSiteFB = (FrameBodyWPAY) body;
			Model model = result.getModel();

			Resource paymentSite = model.createURI(paymentSiteFB.getUrlLink());
			model.addStatement(resourceMap.get(ID3Util.TRACK),
					MO.paid_download, paymentSite);
			// FIXME: foaf:primaryTopic ?
			ID3Util.checkStatementSubject(model, paymentSite,
					FOAF.primaryTopic, resourceMap.get(ID3Util.TRACK),
					BIBO.Document);
		}
	},
	WPUB("Publishers official webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWPUB publisherSiteFB = (FrameBodyWPUB) body;
			Model model = result.getModel();

			ID3Util.preparePublisherConnection(model, resourceMap);

			ID3Util.createPageLink(model, publisherSiteFB.getUrlLink(),
					resourceMap.get(ID3Util.LABEL), FOAF.homepage);
		}
	},
	WXXX("User defined URL link frame", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyWXXX wxxx = (FrameBodyWXXX) body;

			String description = wxxx.getDescription();
			UserDefinedDescription userDefinedDescription = UserDefinedDescription
					.getDescriptionByStringId(description);
			userDefinedDescription.process(body, result, resourceMap);
		}
	},

	// these frames are new, they appeared in the 2.4.0 version of the standard
	// http://www.id3.org/id3v2.4.0-changes
	ASPI("Audio seek point index", false), // can probably be handled with Audio
	// Features and Timeline Ontology;
	// FIXME currently not supported by
	// PMKB
	EQU2("Equalisation (2)", false), // can probably be handled with Audio
	// Features and Timeline Ontology; FIXME
	// currently not supported by PMKB
	RVA2("Relative volume adjustment (2)", false), // can probably be handled
	// with Audio Features and
	// Timeline Ontology; FIXME
	// currently not supported
	// by PMKB
	SEEK("Seek frame", false), // // for internal ID3 tag handling, or?; FIXME
	// currently not supported by PMKB
	SIGN("Signature frame", false), // used WebID signatures here?; FIXME
	// currently not supported by PMKB
	TDEN("Encoding time", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTDEN encodingTimeFB = (FrameBodyTDEN) body;
			Model model = result.getModel();

			// relate to audio file signal
			ID3Util.checkStatementObject(model, result.getDescribedUri(),
					MO.encodes, resourceMap.get(ID3Util.SIGNAL), MO.Signal);

			// a timestamp describing when the audio was encoded
			Date encodingTime = ID3Util.id3v24timestampToDate(encodingTimeFB
					.getFirstTextValue());

			ID3Util.addDateLiteral(model, resourceMap.get(ID3Util.SIGNAL),
					DCTERMS.created, encodingTime);
		}
	},
	TDOR("Original release time", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTDOR originalReleaseTimeFB = (FrameBodyTDOR) body;
			Model model = result.getModel();

			ID3Util.prepareOriginalReleaseEventConnection(model, resourceMap);

			// a timestamp describing when the original recording of the audio
			// was released - that's why original release event (?)
			Date originalReleaseTime = ID3Util
					.id3v24timestampToDate(originalReleaseTimeFB
							.getFirstTextValue());

			ID3Util.createTimeInstant(model, resourceMap
					.get(ID3Util.ORIGINALRELEASEEVENT), originalReleaseTime);

		}
	},
	TDRC("Recording time", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTDRC recordingTimeFB = (FrameBodyTDRC) body;
			Model model = result.getModel();

			// relate to "master signal"
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RECORDING), MO.produced_signal, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.Recording);

			// a timestamp describing when the audio was recorded
			Date recordingTime = ID3Util.id3v24timestampToDate(recordingTimeFB
					.getFirstTextValue());

			ID3Util.createTimeInstant(model,
					resourceMap.get(ID3Util.RECORDING), recordingTime);
		}
	},
	TDRL("Release time", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTDRL releaseTimeFB = (FrameBodyTDRL) body;
			Model model = result.getModel();

			ID3Util.prepareReleaseEventConnection(model, resourceMap);

			// a timestamp describing when the audio was first (!) released -
			// how should I find the URI of the first (!) release now - I add it
			// for the moment to RELEASEEVENT
			Date releaseTime = ID3Util.id3v24timestampToDate(releaseTimeFB
					.getFirstTextValue());

			ID3Util.createTimeInstant(model, resourceMap.get(ID3Util.RELEASE),
					releaseTime);
		}
	},
	TDTG("Tagging time", false), // a timestamp describing then the audio was
	// tagged; this is possible by using
	// tags:Tagging, however, the we have to
	// store the tags from TXXX:TAGS (if they
	// mean these tags ;) ) somewhere and create
	// a tags:Tagging based knowledge
	// representation, FIXME: currently not
	// supported by PMKB
	TIPL("Involved people list", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTIPL tipl = (FrameBodyTIPL) body;

			ValuePairs valuePairs = tipl.getPairing();
			List<Pair> pairList = valuePairs.getMapping();
			for (Pair pair : pairList)
			{
				UserDefinedDescription userDefinedDescription = UserDefinedDescription
						.getDescriptionByStringId(pair.getKey());
				userDefinedDescription.process(result, resourceMap, pair
						.getValue());
			}
		}
	},
	TMCL("Musician credits list", false), // one can get instruments of
	// performers out of this frame
	// somehow (Every odd field is an
	// instrument and every even is an
	// artist or a comma delimited list
	// of artists); FIXME: currently not
	// supported by PMKB
	TMOO("Mood", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTMOO moodFB = (FrameBodyTMOO) body;
			Model model = result.getModel();

			// relate to "master signal"
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);

			ID3Util.addStringLiteral(model, resourceMap
					.get(ID3Util.MASTERSIGNAL), AO.mood, moodFB
					.getFirstTextValue());
		}
	},
	TPRO("Produced notice", false), // the string must begin with a year ... is
	// intended for the production copyright
	// holder of the original sound; FIXME:
	// currently not supported by PMKB
	TSOA("Album sort order", false), // do we need this?; FIXME: currently not
	// supported by PMKB
	TSOP("Performer sort order", false), // do we need this?; FIXME: currently
	// not supported by PMKB
	TSOT("Title sort order", false), // do we need this?; FIXME currently not
	// supported by PMKB
	TSST("Set subtitle", false), // is intended for the subtitle of the part of
	// a set this track belongs to (?); FIXME:
	// currently not supported by PMKB

	// FIXME: these frames were present in ID3 v 2.3.0, but have been deprecated
	// in
	// 2.4.0 see: http://www.id3.org/id3v2.4.0-changes; maybe one still need
	// these for legacy support

	/** This frame is replaced by the EQU2 frame, 'Equalisation (2)' [F:4.12]. */
	EQUA("Equalization", false), // FIXME: currently not supported by PMKB
	/**
	 * This frame is replaced by the two frames TMCL, 'Musician credits list'
	 * [F:4.2.2], and TIPL, 'Involved people list' [F:4.2.2].
	 */
	IPLS("Involved people list", false), // FIXME: currently not supported by
	// PMKB
	/**
	 * This frame is replaced by the RVA2 frame, 'Relative volume adjustment
	 * (2)' [F:4.11].
	 */
	RVAD("Relative volume adjustment", false), // FIXME: currently not supported
	// by PMKB
	/** This frame is replaced by the TDRC frame, 'Recording time' [F:4.2.5]. */
	TDAT("Date", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTDAT tdat = (FrameBodyTDAT) body;
			Model model = result.getModel();
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
						// relate to "master signal"
						ID3Util.checkStatementSubject(model, resourceMap
								.get(ID3Util.MASTERSIGNAL), MO.published_as,
								resourceMap.get(ID3Util.TRACK), MO.Signal);
						ID3Util.checkStatementSubject(model, resourceMap
								.get(ID3Util.RECORDING), MO.produced_signal,
								resourceMap.get(ID3Util.MASTERSIGNAL),
								MO.Recording);

						int year = Integer.parseInt(yearString);
						String time = id3v2.getFirst(TIME.toString());
						if (time.length() > 0)
						{
							int hour = Integer.parseInt(text.substring(0, 2));
							int minute = Integer.parseInt(text.substring(2, 4));
							Calendar calendar = new GregorianCalendar(year,
									month, day, hour, minute);

							ID3Util
									.createTimeInstant(model, resourceMap
											.get(ID3Util.RECORDING), calendar
											.getTime());
						}
						else
						{
							Calendar calendar = new GregorianCalendar(year,
									month, day);

							ID3Util
									.createTimeInstant(model, resourceMap
											.get(ID3Util.RECORDING), calendar
											.getTime());
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
	TIME("Time", false), // this is covered by the TDAT frame
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
			FrameBodyTORY originalReleaseYearFB = (FrameBodyTORY) body;
			Model model = result.getModel();

			ID3Util.prepareOriginalReleaseEventConnection(model, resourceMap);

			ID3Util.createTimeInstantWithYear(model, resourceMap
					.get(ID3Util.ORIGINALRELEASEEVENT), originalReleaseYearFB
					.getFirstTextValue());
		}
	},
	/** This frame is replaced by the TDRC frame, 'Recording time' [F:4.2.5]. */
	TRDA("Recording dates", false), // is a intended to be used as complement to
	// the "TYER", "TDAT" and "TIME" frames.
	// E.g. "4th-7th June, 12th June" in
	// combination with the "TYER" frame; needs
	// a wrapper; FIXME: currently not supported
	// by PMKB
	/**
	 * The information contained in this frame is in the general case either
	 * trivial to calculate for the player or impossible for the tagger to
	 * calculate. There is however no good use for such information. The frame
	 * is therefore completely deprecated.
	 */
	TSIZ("Size", false), // do we need this?; FIXME: currently not supported by
	// PMKB
	/** This frame is replaced by the TDRC frame, 'Recording time' [F:4.2.5]. */
	TYER("Year", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTYER releaseYearFB = (FrameBodyTYER) body;
			Model model = result.getModel();

			ID3Util.prepareReleaseEventConnection(model, resourceMap);

			ID3Util.createTimeInstantWithYear(model, resourceMap
					.get(ID3Util.RELEASEEVENT), releaseYearFB
					.getFirstTextValue());

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
