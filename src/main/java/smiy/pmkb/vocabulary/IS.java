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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Wed Nov 03 09:54:29 CET 2010
 * input file: /workspacePMKB/pmkb/src/main/resources/smiy/pmkb/vocabulary/infoservice.owl
 * namespace: http://purl.org/ontology/is/core#
 */
public class IS {

    /** Path to the ontology resource */
    public static final String IS_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/infoservice.owl";

    /**
     * Puts the IS ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getISOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(IS_RESOURCE_PATH, IS.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + IS_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for IS */
    public static final URI NS_IS = new URIImpl("http://purl.org/ontology/is/core#");
    /**
     * Type: Class <br/>
     * Label: Information Service@en  <br/>
     * Comment: Extended definition:

	"An Information Service is this part of an Information System that serves data/knowledge/information to customers and collects it 
	from its contributors, to manage and store it by optionally using administrators."

Please refer also this article[1] about the definition of the term 'Information Service'.

This concept is for linking a piece of information of a specific concept instance (or at least website links or other data representations 
of this concept instance), e.g. a foaf:Agent, a mo:Track or a mo:MusicArtist to a related website of a specific information service (modelled 
as individual of is:InfoService), e.g. Wikipedia, MySpace, MusicBrainz, Discogs, Last.fm, Pandora, BBC, ... . With this concept it is possible 
to describe the underlying information services of that knowledge representation more in detail, so that the client, which consumes that 
'linked data' could choose, which source it likes to use by evaluating the description of the information service of that website link or 
other data representation.
Please use for further is:InfoService instances the namespace "http://purl.org/ontology/is/inst/".


[1] https://infoserviceonto.wordpress.com/2010/06/23/what-is-an-information-service/@en  <br/>
     */
    public static final URI InfoService = new URIImpl("http://purl.org/ontology/is/core#InfoService");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Information Service Contributor Type@en  <br/>
     * Comment: This concept is for describing the different contributor types of information services, e.g. expert, 
community or mixed. Please feel free to define further information service contributor types.
Please use therefore the namespace "http://purl.org/ontology/is/ctypes/".@en  <br/>
     */
    public static final URI InfoServiceContributorType = new URIImpl("http://purl.org/ontology/is/core#InfoServiceContributorType");
    /**
     * Type: Class <br/>
     * Label: Information Service Quality@en  <br/>
     * Comment: This concept is for describing specific quality levels or ratings, e.g. good or bad or more detailed ones, of 
information services. Please feel free to use this concept as hook for more complex and detailed information service quality description 
modellings in sub ontologies. Please use therefore the domain "http://purl.org/ontology/is/quality/". Futhermore, such information 
service ratings could be done by different information service rating agencies, so that the customer of such ratings could select 
its information service ratings agency of choice.@en  <br/>
     */
    public static final URI InfoServiceQuality = new URIImpl("http://purl.org/ontology/is/core#InfoServiceQuality");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Information Service Type@en  <br/>
     * Comment: This concept is for describing the type of an information service, e.g. 'social network service', 
'recommender service' or 'encyclopedia'. Please feel free to define further information service types for categorization.
Please use therefore the namespace "http://purl.org/ontology/is/types/".@en  <br/>
     */
    public static final URI InfoServiceType = new URIImpl("http://purl.org/ontology/is/core#InfoServiceType");
    /**
     * Type: Property <br/>
     * Label: has info service@en  <br/>
     * Comment: Every subject related by this property is made available by an is:InfoService individual. This property could be used to associate a semantic graph based description or especially a website link, e.g. typed as foaf:Document, to the specific is:InfoService individual. This enables the consumer of this resource to retrieve more information (descriptions, ratings) about the underlying information service of this resource.@en  <br/>
     * Range: http://purl.org/ontology/is/core#InfoService  <br/>
     */
    public static final URI info_service = new URIImpl("http://purl.org/ontology/is/core#info_service");
    /**
     * Type: Property <br/>
     * Label: has info service contributor type@en  <br/>
     * Comment: With this property it is possible to associate a specific information service contributor type, e.g. expert, 
community or mixed, to an is:InfoService instance.@en  <br/>
     * Domain: http://purl.org/ontology/is/core#InfoService  <br/>
     * Range: http://purl.org/ontology/is/core#InfoServiceContributorType  <br/>
     */
    public static final URI info_service_contributor_type = new URIImpl("http://purl.org/ontology/is/core#info_service_contributor_type");
    /**
     * Type: Property <br/>
     * Label: has info service quality@en  <br/>
     * Comment: With this property it is possible to associate a specific quality level, information service quality rating
or an extended information service quality description to an is:InfoService instance@en  <br/>
     * Domain: http://purl.org/ontology/is/core#InfoService  <br/>
     * Range: http://purl.org/ontology/is/core#InfoServiceQuality  <br/>
     */
    public static final URI info_service_quality = new URIImpl("http://purl.org/ontology/is/core#info_service_quality");
    /**
     * Type: Property <br/>
     * Label: has info service type@en  <br/>
     * Comment: With this property it is possible to associate a specific information service type, e.g. 'social network service', 
'recommender service' or 'encyclopedia', to an is:InfoService instance. This property could be used multiple times that means an 
is:InfoService instance could be for example of the information service type 'social network site' and 'recommender system'.@en  <br/>
     * Domain: http://purl.org/ontology/is/core#InfoService  <br/>
     * Range: http://purl.org/ontology/is/core#InfoServiceType  <br/>
     */
    public static final URI info_service_type = new URIImpl("http://purl.org/ontology/is/core#info_service_type");
    /**
     * Type: Property <br/>
     * Label: has main subject@en  <br/>
     * Comment: This property is for defining the main subject of an is:InfoService instance that means this 
info service address mainly this concern.@en  <br/>
     * Domain: http://purl.org/ontology/is/core#InfoService  <br/>
     */
    public static final URI main_subject = new URIImpl("http://purl.org/ontology/is/core#main_subject");
}
