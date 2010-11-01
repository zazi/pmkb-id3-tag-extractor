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
 * The media types of the TMED frame.
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
		for (ReleaseStatusUri key : values())
		{
			urisToNumbersMap.put(key.getUri(), key);
		}
	}

	private static HashMap<String, ReleaseStatusUri> urisToStringsMap;

	static
	{
		urisToStringsMap = new HashMap<String, ReleaseStatusUri>(
				2 * values().length);
		for (ReleaseStatusUri key : values())
		{
			urisToStringsMap.put(key.getId(), key);
		}
	}

	public static ReleaseStatusUri getKeyByUri(URI uri)
	{
		return urisToNumbersMap.get(uri);
	}

	public static ReleaseStatusUri getKeyByStringId(String id)
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