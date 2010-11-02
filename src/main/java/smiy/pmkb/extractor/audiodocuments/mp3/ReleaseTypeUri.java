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
 * The MusicBrainz release types.
 */
public enum ReleaseTypeUri
{

	ALBUM("Album", MO.album), SINGLE("Single", MO.single), EP("EP", MO.ep), COMPILATION(
			"Compilation", MO.compilation), SOUNDTRACK("Soundtrack",
			MO.soundtrack), SPOKENWORD("Spokenword", MO.spokenword), INTERVIEW(
			"Interview", MO.interview), AUDIOBOOK("Audiobook", MO.audiobook), LIVE(
			"Live", MO.live), REMIX("Remix", MO.remix);

	private String id;
	private URI uri;

	ReleaseTypeUri(String id, URI uri)
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

	private static HashMap<URI, ReleaseTypeUri> urisToNumbersMap;

	static
	{
		urisToNumbersMap = new HashMap<URI, ReleaseTypeUri>(2 * values().length);
		for (ReleaseTypeUri releaseTypeUri : values())
		{
			urisToNumbersMap.put(releaseTypeUri.getUri(), releaseTypeUri);
		}
	}

	private static HashMap<String, ReleaseTypeUri> urisToStringsMap;

	static
	{
		urisToStringsMap = new HashMap<String, ReleaseTypeUri>(
				2 * values().length);
		for (ReleaseTypeUri releaseTypeUri : values())
		{
			urisToStringsMap.put(releaseTypeUri.getId(), releaseTypeUri);
		}
	}

	public static ReleaseTypeUri getReleaseTypeUriByUri(URI uri)
	{
		return urisToNumbersMap.get(uri);
	}

	public static ReleaseTypeUri getReleaseTypeUriByStringId(String id)
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