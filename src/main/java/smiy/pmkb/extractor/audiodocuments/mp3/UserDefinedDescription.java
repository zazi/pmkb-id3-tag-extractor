/**
 * Copyright (c) 2010 SMI.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 * 
 * @author Bob Ferris
 */
package smiy.pmkb.extractor.audiodocuments.mp3;

import java.util.HashMap;

import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTXXX;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.vocabulary.RDF;
import org.semanticdesktop.aperture.rdf.RDFContainer;
import org.semanticdesktop.aperture.rdf.util.ModelUtil;

import smiy.pmkb.vocabulary.AO;
import smiy.pmkb.vocabulary.DC;
import smiy.pmkb.vocabulary.DCTERMS;
import smiy.pmkb.vocabulary.EVENT;
import smiy.pmkb.vocabulary.FOAF;
import smiy.pmkb.vocabulary.FRBR;
import smiy.pmkb.vocabulary.MO;
import smiy.pmkb.vocabulary.WGS84;

/**
 * An enumeration of (predefined) user defined text information frames.
 */
public enum UserDefinedDescription
{
	// let's handle some predefined descriptors
	AMAZON_ASIN(FrameBodyTXXX.AMAZON_ASIN, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			// this should related to its Amazon ASIN page (?)
			// let's take the track for the moment ;)
			model.addStatement(resourceMap.get(ID3Util.TRACK), MO.amazon_asin,
					txxx.getFirstTextValue());
		}
	},
	BARCORDE(FrameBodyTXXX.BARCODE, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);

			// since we don't of which type (e.g. EAN or UPC) the barcode
			// is, we use the general property for it
			ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.RELEASE),
					MO.gtin, txxx.getFirstTextValue());
		}
	},
	CATALOG_NO(FrameBodyTXXX.CATALOG_NO, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);

			ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.RELEASE),
					MO.catalogue_number, txxx.getFirstTextValue());
		}
	},
	MOOD(FrameBodyTXXX.MOOD, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			// these are now personal mood associations and added to the own
			// exemplar; add mood description as string
			ID3Util.addStringLiteral(model, result.getDescribedUri(), AO.mood,
					txxx.getFirstTextValue());
		}
	},
	MUSICBRAINZ_ALBUM_ARTISTID(FrameBodyTXXX.MUSICBRAINZ_ALBUM_ARTISTID, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);
			ID3Util.checkStatementObject(model, resourceMap
					.get(ID3Util.RELEASE), DCTERMS.creator, resourceMap
					.get(ID3Util.ALBUMARTIST), MO.MusicArtist);

			// MusicBrainz Release Artist Id
			// add MB GUID as string
			ID3Util.addStringLiteral(model, resourceMap
					.get(ID3Util.ALBUMARTIST), MO.musicbrainz_guid, txxx
					.getFirstTextValue());
		}
	},
	MUSICBRAINZ_ALBUM_COUNTRY(FrameBodyTXXX.MUSICBRAINZ_ALBUM_COUNTRY, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
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

			// Release Country
			// add country name
			Resource country = ModelUtil.generateRandomResource(model);
			model.addStatement(resourceMap.get(ID3Util.RELEASEEVENT),
					EVENT.place, country);
			model.addStatement(country, RDF.type, WGS84.SpatialThing);
			ID3Util.addStringLiteral(model, country, DC.title, txxx
					.getFirstTextValue());
		}
	},
	MUSICBRAINZ_ALBUM_STATUS(FrameBodyTXXX.MUSICBRAINZ_ALBUM_STATUS, true)
	{

		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);

			// Release Status
			model.addStatement(resourceMap.get(ID3Util.RELEASE),
					MO.release_status, ReleaseStatusUri
							.getReleaseStatusUriByStringId(
									txxx.getFirstTextValue()).getUri());
		}
	},
	MUSICBRAINZ_ALBUM_TYPE(FrameBodyTXXX.MUSICBRAINZ_ALBUM_TYPE, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);

			// Release Type
			model.addStatement(resourceMap.get(ID3Util.RELEASE),
					MO.release_type, ReleaseTypeUri
							.getReleaseTypeUriByStringId(
									txxx.getFirstTextValue()).getUri());
		}
	},
	MUSICBRAINZ_ALBUMID(FrameBodyTXXX.MUSICBRAINZ_ALBUMID, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);

			// MusicBrainz Release Id
			// add MB GUID as string
			ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.RELEASE),
					MO.musicbrainz_guid, txxx.getFirstTextValue());
		}
	},
	MUSICBRAINZ_DISCID(FrameBodyTXXX.MUSICBRAINZ_DISCID, false), // FIXME:
	// currently not
	// supported by
	// PMKB
	MUSICBRAINZ_RELEASE_GROUPID(FrameBodyTXXX.MUSICBRAINZ_RELEASE_GROUPID, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
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
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASEEVENT), EVENT.factor, resourceMap
					.get(ID3Util.SIGNALGROUP), MO.SignalGroup);

			// MusicBrainz Release Group Id
			// add MB GUID as string
			ID3Util.addStringLiteral(model, resourceMap
					.get(ID3Util.SIGNALGROUP), MO.musicbrainz_guid, txxx
					.getFirstTextValue());
		}
	},
	MUSICBRAINZ_WORKID(FrameBodyTXXX.MUSICBRAINZ_WORKID, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			// I use here currently frbr:subject, maybe a proper (inverse)
			// relation, e.g. mo:musical_work, might be better
			// FIXME: currently it is a work to item relation
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALWORK), FRBR.subject, result
					.getDescribedUri(), MO.MusicalWork);

			// MusicBrainz Work Id
			// add MB GUID as string
			ID3Util.addStringLiteral(model, resourceMap
					.get(ID3Util.MUSICALWORK), MO.musicbrainz_guid, txxx
					.getFirstTextValue());
		}
	},
	MUSICIP_ID(FrameBodyTXXX.MUSICIP_ID, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			// relate to audio file signal
			ID3Util.checkStatementObject(model, result.getDescribedUri(),
					MO.encodes, resourceMap.get(ID3Util.SIGNAL), MO.Signal);

			// MusicIP PUID
			// add MB PUID as string
			ID3Util.addStringLiteral(model, resourceMap.get(ID3Util.SIGNAL),
					MO.puid, txxx.getFirstTextValue());
		}
	},
	PERFORMER(FrameBodyTXXX.PERFORMER, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			// relate to master signal
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.SIGNAL), MO.published_as, resourceMap
					.get(ID3Util.TRACK), MO.Signal);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.PERFORMANCE), MO.recorded_as, resourceMap
					.get(ID3Util.SIGNAL), MO.Performance);

			ID3Util.addAgent(model, resourceMap.get(ID3Util.PERFORMANCE),
					MO.performer, MO.MusicArtist, txxx.getFirstTextValue());

		}
	},
	SCRIPT(FrameBodyTXXX.SCRIPT, false), // belongs to language representation,
	// e.g. language = english and script =
	// latin (http://en.wikipedia.org/wiki/ISO_15924 or
	// http://en.wikipedia.org/wiki/ISO_639-2 - syntax encoding); FIXME:
	// currently
	// not supported
	// by PMKB
	TAGS(FrameBodyTXXX.TAGS, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			// FIXME: this will create every time a new tag URI (!)
			// these are now personal tags and added to the own exemplar
			Resource tag = ModelUtil.generateRandomResource(model);
			model.addStatement(result.getDescribedUri(),
					smiy.pmkb.vocabulary.TAGS.taggedWithTag, tag);
			model.addStatement(tag, RDF.type, smiy.pmkb.vocabulary.TAGS.Tag);
			ID3Util.addStringLiteral(model, tag,
					smiy.pmkb.vocabulary.TAGS.name, txxx.getFirstTextValue());
		}
	},
	ALBUM_ARTIST(FrameBodyTXXX.ALBUM_ARTIST, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.MUSICALBUM), MO.track, resourceMap
					.get(ID3Util.TRACK), MO.Record);
			ID3Util.checkStatementSubject(model, resourceMap
					.get(ID3Util.RELEASE), MO.record, resourceMap
					.get(ID3Util.MUSICALBUM), MO.Release);
			ID3Util.checkStatementObject(model, resourceMap
					.get(ID3Util.RELEASE), DCTERMS.creator, resourceMap
					.get(ID3Util.ALBUMARTIST), MO.MusicArtist);

			ID3Util.addStringLiteral(model, resourceMap
					.get(ID3Util.ALBUMARTIST), FOAF.name, txxx
					.getFirstTextValue());

		}
	},
	FBPM(FrameBodyTXXX.FBPM, true)
	{
		public void process(AbstractTagFrameBody body, RDFContainer result,
				HashMap<String, Resource> resourceMap)
		{
			FrameBodyTXXX txxx = (FrameBodyTXXX) body;
			Model model = result.getModel();

			ID3Util.checkBPM(model, resourceMap, Float.valueOf(
					txxx.getFirstTextValue()).floatValue());
		}
	};

	private String name;
	private boolean isSupported;
	private static HashMap<String, UserDefinedDescription> descriptionsToStringsMap;

	UserDefinedDescription(String name, boolean isSupported)
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

	static
	{
		descriptionsToStringsMap = new HashMap<String, UserDefinedDescription>(
				2 * values().length);
		for (UserDefinedDescription key : values())
		{
			descriptionsToStringsMap.put(key.getName(), key);
		}
	}

	public static UserDefinedDescription getDescriptionByStringId(String id)
	{
		if (id == null)
		{
			return null;
		}
		else
		{
			return descriptionsToStringsMap.get(id);
		}
	}

	public void process(AbstractTagFrameBody body, RDFContainer result,
			HashMap<String, Resource> resourceMap)
	{
		// the default behavior for unsupported frames is to do nothing
	}

}
