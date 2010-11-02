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

import org.ontoware.rdf2go.model.node.URI;

import smiy.pmkb.vocabulary.MO;

/**
 * The MusicBrainz release states.
 */
public enum ReleaseStatusUri
{

	OFFICIAL("Official", MO.official), PROMOTION("Promotion", MO.promotion), BOOTLEG(
			"Bootleg", MO.bootleg);

	private String id;
	private URI uri;

	ReleaseStatusUri(String id, URI uri)
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

	private static HashMap<URI, ReleaseStatusUri> urisToNumbersMap;

	static
	{
		urisToNumbersMap = new HashMap<URI, ReleaseStatusUri>(
				2 * values().length);
		for (ReleaseStatusUri releaseStatusUri : values())
		{
			urisToNumbersMap.put(releaseStatusUri.getUri(), releaseStatusUri);
		}
	}

	private static HashMap<String, ReleaseStatusUri> urisToStringsMap;

	static
	{
		urisToStringsMap = new HashMap<String, ReleaseStatusUri>(
				2 * values().length);
		for (ReleaseStatusUri releaseStatusUri : values())
		{
			urisToStringsMap.put(releaseStatusUri.getId(), releaseStatusUri);
		}
	}

	public static ReleaseStatusUri getReleaseStatusUriByUri(URI uri)
	{
		return urisToNumbersMap.get(uri);
	}

	public static ReleaseStatusUri getReleaseStatusUriByStringId(String id)
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