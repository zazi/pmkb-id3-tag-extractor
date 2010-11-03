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
import java.util.HashMap;
import java.util.TimeZone;

import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.ontoware.rdf2go.exception.ModelException;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.vocabulary.RDF;
import org.ontoware.rdf2go.vocabulary.XSD;
import org.semanticdesktop.aperture.rdf.RDFContainer;
import org.semanticdesktop.aperture.rdf.util.ModelUtil;

import smiy.pmkb.vocabulary.BIBO;
import smiy.pmkb.vocabulary.CO;
import smiy.pmkb.vocabulary.DC;
import smiy.pmkb.vocabulary.DCTERMS;
import smiy.pmkb.vocabulary.EVENT;
import smiy.pmkb.vocabulary.FOAF;
import smiy.pmkb.vocabulary.FRBR;
import smiy.pmkb.vocabulary.IS;
import smiy.pmkb.vocabulary.MO;
import smiy.pmkb.vocabulary.MT;
import smiy.pmkb.vocabulary.PBO;
import smiy.pmkb.vocabulary.PO;
import smiy.pmkb.vocabulary.TIME;
import smiy.pmkb.vocabulary.TL;

/**
 * This class contains utility methods that facilitate the generation of various
 * values from an RDF2Go model.
 */
public class ID3Util
{
	public static final String TRACK = "track";
	public static final String TRACKARTIST = "trackArtist";
	public static final String MUSICALBUM = "musicAlbum";
	public static final String RELEASE = "release";
	public static final String RELEASEEVENT = "releaseEvent";
	public static final String SIGNAL = "SIGNAL";
	/**
	 * "master signal" - this must be not really the master signal of a
	 * recording, however, the signal that is related to some (published)
	 * mo:Track instances
	 */
	public static final String MASTERSIGNAL = "masterSignal";
	public static final String MUSICALWORK = "musicalWork";
	public static final String LYRICS = "lyrics";
	public static final String ORIGINALSIGNAL = "originalSignal";
	public static final String ORIGINALMUSICALMANIFESTATION = "originalMusicalManifestation";
	public static final String ORIGINALLYRICS = "originalLyrics";
	public static final String PERFORMANCE = "performance";
	public static final String MUSICSEGMENT = "musicSegment";
	public static final String SEGMENTINTERVAL = "segmentInterval";
	public static final String EPISODETIMELINE = "episodeTimeline";
	public static final String VERSIONINTERVAL = "versionInterval";
	public static final String EPISODEVERSION = "episodeVersion";
	public static final String BROADCAST = "broadcast";
	public static final String OUTLET = "outlet";
	public static final String SERVICE = "service";
	public static final String ALBUMARTIST = "albumArtist";
	public static final String SIGNALGROUP = "signalGroup";
	public static final String LABEL = "label";
	public static final String ORIGINALRELEASEEVENT = "originalReleaseEvent";
	public static final String RECORDING = "recording";

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

	public static void addStringLiteral(Model model, Resource subject,
			URI predicate, String stringLiteral)
	{
		try
		{
			model.addStatement(subject, predicate, ModelUtil.createLiteral(
					model, stringLiteral));
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

	public static void addIntegerLiteral(Model model, Resource subject,
			URI predicate, int integerLiteral)
	{
		try
		{
			model.addStatement(subject, predicate, ModelUtil.createLiteral(
					model, integerLiteral));
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

	public static void addDateLiteral(Model model, Resource subject,
			URI predicate, Date dateLiteral)
	{
		try
		{
			// FIXME: is Data date format == xsd data format? - no, it must be
			// formatted (DateFormat ...)
			model.addStatement(subject, predicate, ModelUtil.createLiteral(
					model, dateLiteral.toString(), XSD._date));
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

	public static void checkArtist(Model model, String value, Resource subject)
	{
		ID3Util
				.addAgent(model, subject, DCTERMS.creator, MO.MusicArtist,
						value);
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

		if (MediaTypeUri.getMediaTypeUriByStringId(mediaTypeShortened) != null)
		{
			MediaTypeUri mediaTypeUriKey = MediaTypeUri
					.getMediaTypeUriByStringId(mediaTypeShortened);

			// handle specific video media types (VHS, S-VHS, Betamax)
			if (mediaTypeUriKey == MediaTypeUri.VID)
			{
				// 4 letter endings, e.g. SVHS or BETA
				String mediaTypeShortenedEnd = mediaType.substring(mediaType
						.length() - 4, mediaType.length() - 1);

				if (MediaTypeUri
						.getMediaTypeUriByStringId(mediaTypeShortenedEnd) != null)
				{
					mediaTypeUri = MediaTypeUri.getMediaTypeUriByStringId(
							mediaTypeShortenedEnd).getUri();
				}
				else
				{
					// 3 letter endings, e.g. VHS
					mediaTypeShortenedEnd = mediaType.substring(mediaType
							.length() - 3, mediaType.length() - 1);

					if (MediaTypeUri
							.getMediaTypeUriByStringId(mediaTypeShortenedEnd) != null)
					{
						mediaTypeUri = MediaTypeUri.getMediaTypeUriByStringId(
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

				if (MediaTypeUri.getMediaTypeUriByStringId(mediaTypeShortened) != null)
				{
					mediaTypeUri = MediaTypeUri.getMediaTypeUriByStringId(
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

	public static void addAgent(Model model, Resource subject, URI predicate,
			URI type, String name)
	{
		Resource agent = ModelUtil.generateRandomResource(model);
		model.addStatement(subject, predicate, agent);
		model.addStatement(agent, RDF.type, type);
		addStringLiteral(model, agent, FOAF.name, name);
	}

	public static void checkCount(Model model, Resource subject, URI predicate,
			int count)
	{
		try
		{
			if (!model.contains(ModelUtil.createStatement(model, subject,
					predicate, ModelUtil.createLiteral(model, count))))
			{
				addIntegerLiteral(model, subject, predicate, count);
			}
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

	public static void checkStatementObject(Model model, Resource subject,
			URI predicate, Resource object, URI type)
	{
		if (!model.contains(ModelUtil.createStatement(model, subject,
				predicate, object)))
		{
			model.addStatement(subject, predicate, object);
			model.addStatement(object, RDF.type, type);
		}
	}

	public static void checkStatementSubject(Model model, Resource subject,
			URI predicate, Resource object, URI type)
	{
		if (!model.contains(ModelUtil.createStatement(model, subject,
				predicate, object)))
		{
			model.addStatement(subject, predicate, object);
			model.addStatement(subject, RDF.type, type);
		}
	}

	public static void checkStream(Model model, RDFContainer result,
			HashMap<String, Resource> resourceMap)
	{
		if (model.contains(ModelUtil.createStatement(model, result
				.getDescribedUri(), RDF.type, MO.AudioFile)))
		{
			// change item type to MO:Stream
			model.removeStatement(result.getDescribedUri(), RDF.type,
					MO.AudioFile);
			model.addStatement(result.getDescribedUri(), RDF.type, MO.Stream);

			// add stream media type on manifestation level (?)
			model.addStatement(resourceMap.get(ID3Util.TRACK), MO.media_type,
					MT.Stream);
		}
	}

	public static void prepareServiceOutletConnection(Model model,
			HashMap<String, Resource> resourceMap)
	{
		// prepare service outlet connection
		ID3Util.checkStatementSubject(model, resourceMap
				.get(ID3Util.MUSICSEGMENT), PO.track, resourceMap
				.get(ID3Util.TRACK), PO.MusicSegment);
		ID3Util.checkStatementObject(model, resourceMap
				.get(ID3Util.MUSICSEGMENT), PO.time, resourceMap
				.get(ID3Util.SEGMENTINTERVAL),
				smiy.pmkb.vocabulary.TIME.Interval);
		ID3Util.checkStatementObject(model, resourceMap
				.get(ID3Util.SEGMENTINTERVAL), TL.timeline, resourceMap
				.get(ID3Util.EPISODETIMELINE), TL.TimeLine);
		ID3Util.checkStatementSubject(model, resourceMap
				.get(ID3Util.VERSIONINTERVAL), TL.timeline, resourceMap
				.get(ID3Util.EPISODETIMELINE),
				smiy.pmkb.vocabulary.TIME.Interval);
		ID3Util.checkStatementSubject(model, resourceMap
				.get(ID3Util.EPISODEVERSION), PO.time, resourceMap
				.get(ID3Util.VERSIONINTERVAL), PO.Version);
		ID3Util.checkStatementSubject(model,
				resourceMap.get(ID3Util.BROADCAST), PO.broadcast_of,
				resourceMap.get(ID3Util.EPISODEVERSION), PO.Broadcast);
		ID3Util.checkStatementObject(model, resourceMap.get(ID3Util.BROADCAST),
				PO.broadcast_on, resourceMap.get(ID3Util.OUTLET), PO.Outlet);
	}

	public static void checkBPM(Model model,
			HashMap<String, Resource> resourceMap, float bpm)
	{
		try
		{
			if (model.contains(ModelUtil.createStatement(model, resourceMap
					.get(ID3Util.SIGNAL), MO.bpm, ModelUtil.createLiteral(
					model, bpm))))
			{
				// relate to master signal
				ID3Util.checkStatementSubject(model, resourceMap
						.get(ID3Util.SIGNAL), MO.published_as, resourceMap
						.get(ID3Util.TRACK), MO.Signal);

				// should be an integer stored as string and now transformed to
				// a
				// float value
				model.addStatement(resourceMap.get(ID3Util.SIGNAL), MO.bpm,
						ModelUtil.createLiteral(model, bpm));
			}
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

	public static void preparePublisherConnection(Model model,
			HashMap<String, Resource> resourceMap)
	{
		prepareReleaseEventConnection(model, resourceMap);

		// FIXME: associates publisher explicitly as label, however it can
		// also be a person
		ID3Util.checkStatementObject(model, resourceMap
				.get(ID3Util.RELEASEEVENT), MO.label, resourceMap
				.get(ID3Util.LABEL), MO.Label);
	}

	public static void prepareReleaseEventConnection(Model model,
			HashMap<String, Resource> resourceMap)
	{
		ID3Util.checkStatementSubject(model, resourceMap
				.get(ID3Util.MUSICALBUM), MO.track, resourceMap
				.get(ID3Util.TRACK), MO.Record);
		ID3Util.checkStatementSubject(model, resourceMap.get(ID3Util.RELEASE),
				MO.record, resourceMap.get(ID3Util.MUSICALBUM), MO.Release);
		ID3Util.checkStatementSubject(model, resourceMap
				.get(ID3Util.RELEASEEVENT), MO.release, resourceMap
				.get(ID3Util.RELEASE), MO.ReleaseEvent);
	}

	public static void createTimeInstant(Model model, Resource subject,
			Date time)
	{
		// create time instant
		Resource timeInstant = ModelUtil.generateRandomResource(model);
		model.addStatement(subject, EVENT.time, timeInstant);
		model.addStatement(timeInstant, RDF.type,
				smiy.pmkb.vocabulary.TIME.Instant);
		addDateLiteral(model, timeInstant, TL.atDate, time);
	}

	public static void createPageLinkWithInfoService(Model model, String url,
			Resource topic, URI infoService, URI pageRelation)
	{
		Resource site = createPageLink(model, url, topic, pageRelation);
		model.addStatement(site, IS.info_service, infoService);
	}

	public static Resource createPageLink(Model model, String url,
			Resource topic, URI pageRelation)
	{
		Resource site = model.createURI(url);
		model.addStatement(site, FOAF.primaryTopic, topic);
		model.addStatement(site, RDF.type, BIBO.Document);
		model.addStatement(topic, pageRelation, site);

		return site;
	}

	public static void createTimeInstantWithYear(Model model, Resource subject,
			String year)
	{
		// create time instant
		Resource releaseTime = ModelUtil.generateRandomResource(model);
		model.addStatement(subject, EVENT.time, releaseTime);
		model.addStatement(releaseTime, RDF.type, TIME.Instant);
		try
		{
			model.addStatement(releaseTime, TL.atYear, ModelUtil.createLiteral(
					model, year, XSD._gYear));
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

	public static void prepareOriginalReleaseEventConnection(Model model,
			HashMap<String, Resource> resourceMap)
	{
		// relate to "master signal"
		ID3Util.checkStatementSubject(model, resourceMap
				.get(ID3Util.MASTERSIGNAL), MO.published_as, resourceMap
				.get(ID3Util.TRACK), MO.Signal);
		ID3Util.checkStatementObject(model, resourceMap
				.get(ID3Util.MASTERSIGNAL), MO.derived_from, resourceMap
				.get(ID3Util.ORIGINALSIGNAL), MO.Signal);
		ID3Util.checkStatementSubject(model, resourceMap
				.get(ID3Util.ORIGINALRELEASEEVENT), EVENT.factor, resourceMap
				.get(ID3Util.ORIGINALSIGNAL), MO.ReleaseEvent);
	}

	public static void prepareOriginalMusicalManifestation(Model model,
			HashMap<String, Resource> resourceMap)
	{
		// relate to "master signal"
		ID3Util.checkStatementSubject(model, resourceMap
				.get(ID3Util.MASTERSIGNAL), MO.published_as, resourceMap
				.get(ID3Util.TRACK), MO.Signal);
		ID3Util.checkStatementObject(model, resourceMap
				.get(ID3Util.MASTERSIGNAL), MO.derived_from, resourceMap
				.get(ID3Util.ORIGINALSIGNAL), MO.Signal);
		ID3Util.checkStatementObject(model, resourceMap
				.get(ID3Util.ORIGINALSIGNAL), FRBR.embodiment, resourceMap
				.get(ID3Util.ORIGINALMUSICALMANIFESTATION),
				MO.MusicalManifestation);
	}

	public static void createPlayCounter(Model model, int playCount,
			String playCounterTitle, Resource mediaObject)
	{
		Resource playCounter = ModelUtil.generateRandomResource(model);
		model.addStatement(playCounter, RDF.type, PBO.PlayBackCounter);
		addIntegerLiteral(model, playCounter, CO.count, playCount);
		addStringLiteral(model, playCounter, DC.title, "ID3 Play counter");
		model.addStatement(playCounter, PBO.media_object, mediaObject);
	}
}
