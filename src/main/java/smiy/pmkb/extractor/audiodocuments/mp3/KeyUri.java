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

import smiy.pmkb.vocabulary.KEYS;

/**
 * The keys of western music.
 */
public enum KeyUri
{

	A("A", KEYS.AMajor), B("B", KEYS.BMajor), C("C", KEYS.CMajor), D("D",
			KEYS.DMajor), E("E", KEYS.EMajor), F("F", KEYS.FMajor), G("G",
			KEYS.GMajor), Ab("Ab", KEYS.AFlatMajor), Bb("Bb", KEYS.BFlatMajor), Cb(
			"Cb", KEYS.CFlatMajor), Db("Db", KEYS.DFlatMajor), Eb("Eb",
			KEYS.EFlatMajor), Gb("Gb", KEYS.GFlatMajor), CSharp("C#",
			KEYS.CSharpMajor), FSharp("F#", KEYS.FSharpMajor), Am("Am",
			KEYS.AMinor), Bm("Bm", KEYS.BMinor), Cm("Cm", KEYS.CMinor), Dm(
			"Dm", KEYS.DMinor), Em("Em", KEYS.EMinor), Fm("Fm", KEYS.FMinor), Gm(
			"Gm", KEYS.FMinor), Abm("Abm", KEYS.AFlatMinor), Bbm("Bbm",
			KEYS.BFlatMinor), Ebm("Ebm", KEYS.EFlatMinor), ASharpm("A#m",
			KEYS.ASharpMinor), CSharpm("C#m", KEYS.CSharpMinor), DSharpm("D#m",
			KEYS.DSharpMinor), FSharpm("F#m", KEYS.FSharpMinor), GSharpm("G#m",
			KEYS.GSharpMinor);

	private String id;
	private URI uri;

	KeyUri(String id, URI uri)
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

	private static HashMap<URI, KeyUri> urisToNumbersMap;

	static
	{
		urisToNumbersMap = new HashMap<URI, KeyUri>(2 * values().length);
		for (KeyUri key : values())
		{
			urisToNumbersMap.put(key.getUri(), key);
		}
	}

	private static HashMap<String, KeyUri> urisToStringsMap;

	static
	{
		urisToStringsMap = new HashMap<String, KeyUri>(2 * values().length);
		for (KeyUri key : values())
		{
			urisToStringsMap.put(key.getId(), key);
		}
	}

	public static KeyUri getKeyByUri(URI uri)
	{
		return urisToNumbersMap.get(uri);
	}

	public static KeyUri getKeyByStringId(String id)
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