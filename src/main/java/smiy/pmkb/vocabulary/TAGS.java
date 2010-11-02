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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Tue Nov 02 18:53:35 CET 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/tags.owl
 * namespace: http://www.holygoat.co.uk/owl/redwood/0.1/tags/
 */
public class TAGS {

    /** Path to the ontology resource */
    public static final String TAGS_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/tags.owl";

    /**
     * Puts the TAGS ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getTAGSOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(TAGS_RESOURCE_PATH, TAGS.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + TAGS_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for TAGS */
    public static final URI NS_TAGS = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: restricted tagging@en  <br/>
     * Comment: A Tagging which has precisely one associated resource, and one associated tag.@en  <br/>
     */
    public static final URI RestrictedTagging = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/RestrictedTagging");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Tag@en  <br/>
     */
    public static final URI Tag = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: tagging@en  <br/>
     * Comment: A reified class which defines an instance of a tagging by an agent of a resource with one or more tags.@en  <br/>
     */
    public static final URI Tagging = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tagging");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: tag name@en  <br/>
     * Comment: The name of a tag. Note that we can't relate this to skos:prefLabel because we cannot guarantee that tags have unique labels in a given conceptual scheme. Or can we?@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     */
    public static final URI name = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/name");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: tag name@en  <br/>
     * Comment: The name of a tag. Note that we can't relate this to skos:prefLabel because we cannot guarantee that tags have unique labels in a given conceptual scheme. Or can we? DEPRECATED 2005-05-19: redundant 'tag'.@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     */
    public static final URI tagName = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/tagName");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: tagged on@en  <br/>
     * Comment: The subject Tagging occurred at the subject time and date.@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tagging  <br/>
     */
    public static final URI taggedOn = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedOn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: associated tag  <br/>
     * Comment: The object is a Tag which plays a role in the subject Tagging.@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tagging  <br/>
     * Range: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     */
    public static final URI associatedTag = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/associatedTag");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: equivalent tag@en  <br/>
     * Comment: The two tags are asserted to be equivalent --- that is, that whenever one is associated with a resource, the other tag can be logically inferred to also be associated. Be very careful with this. I'm not sure if this should be a subproperty of owl:sameAs.@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     * Range: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     */
    public static final URI equivalentTag = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/equivalentTag");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: is tag of@en  <br/>
     * Comment: Indicates that the subject tag applies to the object resource. This does not assert by who, when, or why the tagging occurred. For that information, use a reified Tagging resource.@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     */
    public static final URI isTagOf = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/isTagOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: related tag@en  <br/>
     * Comment: The two tags are asserted as being related. This might be symmetric, but it certainly isn't transitive.@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     * Range: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     */
    public static final URI relatedTag = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/relatedTag");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: tag@en  <br/>
     * Comment: The relationship between a resource and a Tagging. Note, of course, that this allows us to tag tags and taggings themselves...@en  <br/>
     * Range: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tagging  <br/>
     */
    public static final URI tag = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/tag");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: tagged by@en  <br/>
     * Comment: The object plays the role of the tagger in the subject Tagging.@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tagging  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI taggedBy = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: tagged resource@en  <br/>
     * Comment: The object is a resource which plays a role in the subject Tagging.@en  <br/>
     * Domain: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tagging  <br/>
     */
    public static final URI taggedResource = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedResource");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: tagged with tag@en  <br/>
     * Comment: Indicates that the subject has been tagged with the object tag. This does not assert by who, when, or why the tagging occurred. For that information, use a reified Tagging resource.@en  <br/>
     * Range: http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag  <br/>
     */
    public static final URI taggedWithTag = new URIImpl("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedWithTag");
}
