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
import java.util.TimeZone;

import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
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
import smiy.pmkb.vocabulary.CO;
import smiy.pmkb.vocabulary.DC;
import smiy.pmkb.vocabulary.DCTERMS;
import smiy.pmkb.vocabulary.FOAF;
import smiy.pmkb.vocabulary.FRBR;
import smiy.pmkb.vocabulary.MO;
import smiy.pmkb.vocabulary.PBO;

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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
			model.addStatement(track, DC.description, ModelUtil.createLiteral(
					model, resultString));
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
			model.addStatement(playcounter, PBO.media_object, track);
		}
	}, // acts as general play counter
	POPM("Popularimeter", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			FrameBodyTALB albumTitleFB = (FrameBodyTALB) body;

			Model model = result.getModel();
			if (!model.contains(ModelUtil.createStatement(model, musicAlbum,
					MO.track, track)))
			{
				model.addStatement(musicAlbum, MO.track, result
						.getDescribedUri());
				model.addStatement(musicAlbum, RDF.type, MO.Record);
			}

			try
			{
				model
						.addStatement(musicAlbum, DC.title, ModelUtil
								.createLiteral(model, albumTitleFB
										.getFirstTextValue()));
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

			id3v1props.remove(NID3.albumTitle);
		}
	},
	TBPM("BPM (beats per minute)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			FrameBodyTBPM bpmFB = (FrameBodyTBPM) body;

			Model model = result.getModel();

			if (!model.contains(ModelUtil.createStatement(model, result
					.getDescribedUri(), MO.encodes, signal)))
			{
				model
						.addStatement(result.getDescribedUri(), MO.encodes,
								signal);
				model.addStatement(signal, RDF.type, MO.Signal);
			}

			// should be an integer stored as string and now transformed to a
			// float value
			model.addStatement(signal, MO.bpm, ModelUtil.createLiteral(model,
					Float.valueOf(bpmFB.getFirstTextValue()).floatValue()));
		}
	},
	TCOM("Composer", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			FrameBodyTCOM composerFB = (FrameBodyTCOM) body;
			Model model = result.getModel();

			// I use here currently frbr:subject, maybe a proper (inverse)
			// relation, e.g. mo:musical_work, might be better
			// FIXME: currently it is a work to item relation
			if (!model.contains(ModelUtil.createStatement(model, musicalWork,
					FRBR.subject, result.getDescribedUri())))
			{
				model.addStatement(musicalWork, FRBR.subject, result
						.getDescribedUri());
				model.addStatement(musicalWork, RDF.type, MO.MusicalWork);
			}

			// relate the musical work to its composition event
			Resource composition = ModelUtil.generateRandomResource(model);
			model.addStatement(musicalWork, MO.composed_in, composition);
			model.addStatement(composition, RDF.type, MO.Composition);

			// relate the composition event to its composer
			Resource composer = ModelUtil.generateRandomResource(model);
			model.addStatement(composition, MO.composer, composer);
			model.addStatement(composer, RDF.type, MO.Composer);
			model.addStatement(composer, FOAF.name, ModelUtil.createLiteral(
					model, composerFB.getFirstTextValue()));
		}
	},
	TCON("Content type", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
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
						GenreUri genreUri = GenreUri.getGenreByIntId(intValue);
						if (genreUri != null)
						{
							// FIXME: a music genre can also be item specific
							// (subjective, personal)
							model.addStatement(track, MO.genre, genreUri
									.getUri());
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
				model.addStatement(track, MO.genre, new URIImpl(
						Namespaces.PMKB_NS + GenreUri.GENRE_RURI + value));
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
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			FrameBodyTEXT lyricistFB = (FrameBodyTEXT) body;
			Model model = result.getModel();

			if (!model.contains(ModelUtil.createStatement(model, track,
					MO.publication_of, lyrics)))
			{
				model.addStatement(track, MO.publication_of, lyrics);
				model.addStatement(lyrics, RDF.type, MO.Lyrics);
			}

			Resource lyricist = ModelUtil.generateRandomResource(model);
			model.addStatement(lyrics, DCTERMS.creator, lyricist);
			model.addStatement(lyricist, RDF.type, FOAF.Person);
			model.addStatement(lyricist, FOAF.name, ModelUtil.createLiteral(
					model, lyricistFB.getFirstTextValue()));
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			FrameBodyTKEY keyFB = (FrameBodyTKEY) body;
			if (keyFB.isValid())
			{
				Model model = result.getModel();

				if (!model.contains(ModelUtil.createStatement(model, result
						.getDescribedUri(), MO.encodes, signal)))
				{
					model.addStatement(result.getDescribedUri(), MO.encodes,
							signal);
					model.addStatement(signal, RDF.type, MO.Signal);
				}

				model.addStatement(signal, MO.key, KeyUri.getKeyByStringId(
						keyFB.getFirstTextValue()).getUri());
			}
		}
	},
	TLAN("Language(s)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.language, ((FrameBodyTLAN) body)
					.getFirstTextValue());
		}
	},
	TLEN("Length", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.length, ((FrameBodyTLEN) body).getFirstTextValue());
		}
	},
	TMED("Media type", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.mediaType, ((FrameBodyTMED) body)
					.getFirstTextValue());
		}
	},
	TOAL("Original album/movie/show title", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.originalAlbumTitle, ((FrameBodyTOAL) body)
					.getFirstTextValue());
		}
	},
	TOFN("Original filename", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.originalFilename, ((FrameBodyTOFN) body)
					.getFirstTextValue());
		}
	},
	TOLY("Original lyricist(s)/text writer(s)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.originalTextWriter, ((FrameBodyTOLY) body)
					.getFirstTextValue(), result);
		}
	},
	TOPE("Original artist(s)/performer(s)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.originalArtist, ((FrameBodyTOPE) body)
					.getFirstTextValue(), result);
		}
	},
	TOWN("File owner/licensee", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.fileOwner, ((FrameBodyTOWN) body)
					.getFirstTextValue(), result);
		}
	},
	TPE1("Lead performer(s)/Soloist(s)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.leadArtist, ((FrameBodyTPE1) body)
					.getFirstTextValue(), result);
			id3v1props.remove(NID3.leadArtist);
		}
	},
	TPE2("Band/orchestra/accompaniment", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.backgroundArtist, ((FrameBodyTPE2) body)
					.getFirstTextValue(), result);
		}
	},
	TPE3("Conductor/performer refinement", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.conductor, ((FrameBodyTPE3) body)
					.getFirstTextValue(), result);
		}
	},
	TPE4("Interpreted, remixed, or otherwise modified by", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.interpretedBy, ((FrameBodyTPE4) body)
					.getFirstTextValue(), result);
		}
	},
	TPOS("Part of a set", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.partOfSet, ((FrameBodyTPOS) body)
					.getFirstTextValue());
		}
	},
	TPUB("Publisher", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.publisher, ((FrameBodyTPUB) body)
					.getFirstTextValue(), result);
		}
	},
	TRCK("Track number/Position in set", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.trackNumber, ((FrameBodyTRCK) body)
					.getFirstTextValue());
			id3v1props.remove(NID3.trackNumber);
		}
	},
	TRSN("Internet radio station name", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.internetRadioStationName, ((FrameBodyTRSN) body)
					.getFirstTextValue());
		}
	},
	TRSO("Internet radio station owner", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			addSimpleContact(NID3.internetRadioStationOwner,
					((FrameBodyTRSO) body).getFirstTextValue(), result);
		}
	},
	TSRC("ISRC (international standard recording code)", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.internationalStandardRecordingCode,
					((FrameBodyTSRC) body).getFirstTextValue());
		}
	},
	TSSE("Software/Hardware and settings used for encoding", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.encodingSettings, ((FrameBodyTSSE) body)
					.getFirstTextValue());
		}
	},
	TXXX("User defined text information frame", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			String description = txxx.getDescription();
			String text = txxx.getText();
			Model model = result.getModel();
			Resource resource = ModelUtil.generateRandomResource(model);
			model.addStatement(resource, RDF.type, NID3.UserDefinedFrame);
			model.addStatement(resource, NID3.userDefinedFrameDescription,
					description);
			model.addStatement(resource, NID3.userDefinedFrameValue, text);
			model.addStatement(result.getDescribedUri(), NID3.userDefinedFrame,
					resource);
		}
	},
	UFID("Unique file identifier", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.uniqueFileIdentifier, ((FrameBodyUFID) body)
					.getOwner()
					+ "/" + ((FrameBodyUFID) body).getIdentifier());
		}
	},
	USER("Terms of use", false), // unsupported in NID3
	USLT("Unsynchronised lyric/text transcription", false)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			result.add(NID3.unsynchronizedTextContent, ((FrameBodyUSLT) body)
					.getLyric());
		}
	},
	WCOM("Commercial information", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWCOM) body).getUrlLink());
			result.add(NID3.commercialInformationURL, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	},
	WCOP("Copyright/Legal information", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWCOP) body).getUrlLink());
			result.add(NID3.copyrightInformationURL, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	},
	WOAF("Official audio file webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWOAF) body).getUrlLink());
			result.add(NID3.officialFileWebpage, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	},
	WOAR("Official artist/performer webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
		{
			Resource resource = result.getModel().createURI(
					((FrameBodyWOAR) body).getUrlLink());
			result.add(NID3.officialArtistWebpage, resource);
			result.getModel().addStatement(resource, RDF.type, RDFS.Resource);
		}
	},
	WOAS("Official audio source webpage", true)
	{
		public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
	TMOO("Mood", false), // not supported by NID3
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
				HashMap<URI, String> id3v1props, RDFContainer result)
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
	private static Resource track;
	private static Resource musicAlbum;
	private static Resource signal;
	private static Resource musicalWork;
	private static Resource lyrics;

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

	public Resource getTrack()
	{
		return track;
	}

	public void setTrack(Resource t)
	{
		track = t;
	}

	public Resource getMusicAlbum()
	{
		return musicAlbum;
	}

	public void setMusicAlbum(Resource mA)
	{
		musicAlbum = mA;
	}

	public Resource getSignal()
	{
		return signal;
	}

	public void setSignal(Resource s)
	{
		signal = s;
	}

	public Resource getMusicalWork()
	{
		return musicalWork;
	}

	public void setMusicalWork(Resource mW)
	{
		musicalWork = mW;
	}

	public Resource getLyrics()
	{
		return lyrics;
	}

	public void setLyrics(Resource l)
	{
		lyrics = l;
	}

	public void process(AbstractTagFrameBody body, AbstractID3v2Tag id3v2,
			HashMap<URI, String> id3v1props, RDFContainer result)
	{
		// the default behavior for unsupported frames is to do nothing
	}

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
	protected Date id3v24timestampToDate(String timestamp)
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
}
