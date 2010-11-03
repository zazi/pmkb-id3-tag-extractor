/*
 * Copyright (c) 2006 - 2010 Aduna and Deutsches Forschungszentrum fuer Kuenstliche Intelligenz DFKI GmbH.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 */
package smiy.pmkb.vocabulary;

import java.io.InputStream;
import java.io.FileNotFoundException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.Syntax;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.semanticdesktop.aperture.util.ResourceUtil;

/**
 * Vocabulary File. Created by
 * org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Wed Nov 03
 * 10:01:45 CET 2010 input file:
 * /src/main/resources/smiy/pmkb/vocabulary/infoserviceindividuals.rdf
 * namespace: http://purl.org/ontology/is/inst/
 */
public class ISI
{

	/** Path to the ontology resource */
	public static final String ISI_RESOURCE_PATH = "smiy/pmkb/vocabulary/infoserviceindividuals.rdf";

	/**
	 * Puts the ISI ontology into the given model.
	 * 
	 * @param model
	 *            The model for the source ontology to be put into.
	 * @throws Exception
	 *             if something goes wrong.
	 */
	public static void getISIOntology(Model model)
	{
		try
		{
			InputStream stream = ResourceUtil.getInputStream(ISI_RESOURCE_PATH,
					ISI.class);
			if (stream == null)
			{
				throw new FileNotFoundException("couldn't find resource "
						+ ISI_RESOURCE_PATH);
			}
			model.readFrom(stream, Syntax.RdfXml);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/** The namespace for ISI */
	public static final URI NS_ISI = new URIImpl(
			"http://purl.org/ontology/is/inst/");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: BBC <br/>
	 * Comment: The largest broadcasting organization in the world. Modelled
	 * here as information service.@en <br/>
	 */
	public static final URI bbc = new URIImpl(
			"http://purl.org/ontology/is/inst/bbc");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: DBPedia <br/>
	 * Comment: DBpedia is a community effort to extract structured information
	 * from Wikipedia and to make this information available on the Web.@en <br/>
	 */
	public static final URI dbpedia = new URIImpl(
			"http://purl.org/ontology/is/inst/dpedia");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: Discogs <br/>
	 * Comment: A website and database of information about music recordings,
	 * and one of the largest online databases of electronic music releases and
	 * is believed to be the largest online database of releases on vinyl media.
	 * Modelled here as information service.@en <br/>
	 */
	public static final URI discogs = new URIImpl(
			"http://purl.org/ontology/is/inst/discogs");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: EchoNest <br/>
	 * Comment: The Echo Nest provides a series of web based solutions for
	 * better search, recommendation and interactivity on the music web
	 * (including musicial fingerprinting). Modelled here as information
	 * service.@en <br/>
	 */
	public static final URI echonest = new URIImpl(
			"http://purl.org/ontology/is/inst/echonest");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: Freebase <br/>
	 * Comment: An online collection of structured data harvested from many
	 * sources. Modelled here as information service.@en <br/>
	 */
	public static final URI freebase = new URIImpl(
			"http://purl.org/ontology/is/inst/freebase");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: Last.fm <br/>
	 * Comment: A popular Internet radio site for streaming music. Modelled here
	 * as information service.@en <br/>
	 */
	public static final URI lastfm = new URIImpl(
			"http://purl.org/ontology/is/inst/lastfm");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: MusicBrainz <br/>
	 * Comment: An open content music database. Modelled here as information
	 * service.@en <br/>
	 */
	public static final URI musicbrainz = new URIImpl(
			"http://purl.org/ontology/is/inst/musicbrainz");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: MySpace <br/>
	 * Comment: A social networking website with a great pool of musician
	 * profiles. Modelled here as information service.@en <br/>
	 */
	public static final URI myspace = new URIImpl(
			"http://purl.org/ontology/is/inst/myspace");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: Pandora <br/>
	 * Comment: An automated music recommendation service. Modelled here as
	 * information service.@en <br/>
	 */
	public static final URI pandora = new URIImpl(
			"http://purl.org/ontology/is/inst/pandora");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: Spotify <br/>
	 * Comment: A proprietary peer-to-peer music streaming service. Modelled
	 * here as information service.@en <br/>
	 */
	public static final URI spotify = new URIImpl(
			"http://purl.org/ontology/is/inst/spotify");
	/**
	 * Type: Instance of http://purl.org/ontology/is/core#InfoService <br/>
	 * Label: Wikipedia <br/>
	 * Comment: A free, web-based, collaborative, multilingual encyclopedia
	 * project. Modelled here as information service.@en <br/>
	 */
	public static final URI wikipedia = new URIImpl(
			"http://purl.org/ontology/is/inst/wikipedia");
}
