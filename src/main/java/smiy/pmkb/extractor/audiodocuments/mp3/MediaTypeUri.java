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
import java.util.Set;

import org.ontoware.rdf2go.model.node.URI;

import smiy.pmkb.vocabulary.MT;

/**
 * The media types of the TMED frame.
 */
public enum MediaTypeUri
{

	DIG("DIG", MT.DigitalMedia), CD("CD", MT.CD), LD("LD", MT.LaserDisc), TT(
			"TT", MT.VinylRecord), MD("MD", MT.MiniDisc), DAT("DAT", MT.DAT), DCC(
			"DCC", MT.DCC), DVD("DVD", MT.DVD), TV("TV", MT.TV), VID("VID",
			MT.Video), RAD("RAD", MT.Radio), TEL("TEL", MT.Telephone), MC("MC",
			MT.CompactCassette), REE("REE", MT.ReelToReel), VHS("VHS", MT.VHS), SVHS(
			"SVHS", MT.SVHS), BETA("BETA", MT.Betamax), ANAWAC("ANA/WAC",
			MT.WaxCylinder), ANA8CA("ANA/8CA", MT.EightTrackCartridge);

	private String id;
	private URI uri;

	MediaTypeUri(String id, URI uri)
	{
		this.id = id;
		this.uri = uri;
	}

	public URI getUri()
	{
		return uri;
	}

	public String getId()
	{
		return id;
	}

	private static HashMap<URI, MediaTypeUri> urisToNumbersMap;

	static
	{
		urisToNumbersMap = new HashMap<URI, MediaTypeUri>(2 * values().length);
		for (MediaTypeUri mediaTypeUri : values())
		{
			urisToNumbersMap.put(mediaTypeUri.getUri(), mediaTypeUri);
		}
	}

	private static HashMap<String, MediaTypeUri> urisToStringsMap;

	static
	{
		urisToStringsMap = new HashMap<String, MediaTypeUri>(
				2 * values().length);
		for (MediaTypeUri mediaTypeUri : values())
		{
			urisToStringsMap.put(mediaTypeUri.getId(), mediaTypeUri);
		}
	}

	public static MediaTypeUri getMediaTypeUriByUri(URI uri)
	{
		return urisToNumbersMap.get(uri);
	}

	public static MediaTypeUri getMediaTypeUriByStringId(String id)
	{
		if (id == null)
		{
			return null;
		}
		else
		{
			return urisToStringsMap.get(id);
		}
	}
}