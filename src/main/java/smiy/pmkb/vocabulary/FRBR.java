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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Tue Oct 26 16:41:55 CEST 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/frbr.owl
 * namespace: http://purl.org/vocab/frbr/core#
 */
public class FRBR {

    /** Path to the ontology resource */
    public static final String FRBR_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/frbr.owl";

    /**
     * Puts the FRBR ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getFRBROntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(FRBR_RESOURCE_PATH, FRBR.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + FRBR_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for FRBR */
    public static final URI NS_FRBR = new URIImpl("http://purl.org/vocab/frbr/core#");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: endeavour@en  <br/>
     * Comment: This class represents any one of the FRBR group one entities.@en  <br/>
     */
    public static final URI Endeavour = new URIImpl("http://purl.org/vocab/frbr/core#Endeavour");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: expression@en  <br/>
     * Comment: This class corresponds to the FRBR group one entity 'Expression'.@en  <br/>
     */
    public static final URI Expression = new URIImpl("http://purl.org/vocab/frbr/core#Expression");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: item@en  <br/>
     * Comment: This class corresponds to the FRBR group one entity 'Item'.@en  <br/>
     */
    public static final URI Item = new URIImpl("http://purl.org/vocab/frbr/core#Item");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: manifestation@en  <br/>
     * Comment: This class corresponds to the FRBR group one entity 'Manifestation'.@en  <br/>
     */
    public static final URI Manifestation = new URIImpl("http://purl.org/vocab/frbr/core#Manifestation");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: work@en  <br/>
     * Comment: This class corresponds to the FRBR group one entity 'Work'.@en  <br/>
     */
    public static final URI Work = new URIImpl("http://purl.org/vocab/frbr/core#Work");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: responsible entity@en  <br/>
     * Comment: This class represents any of the FRBR group two entities.@en  <br/>
     */
    public static final URI ResponsibleEntity = new URIImpl("http://purl.org/vocab/frbr/core#ResponsibleEntity");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: corporate body@en  <br/>
     * Comment: This class corresponds to the FRBR group two entity 'Corporate Body'.@en  <br/>
     */
    public static final URI CorporateBody = new URIImpl("http://purl.org/vocab/frbr/core#CorporateBody");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: person@en  <br/>
     * Comment: This class corresponds to the FRBR group two entity 'Person'.@en  <br/>
     */
    public static final URI Person = new URIImpl("http://purl.org/vocab/frbr/core#Person");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: subject@en  <br/>
     * Comment: This class represents any of the FRBR group three entities.@en  <br/>
     */
    public static final URI Subject = new URIImpl("http://purl.org/vocab/frbr/core#Subject");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: event@en  <br/>
     * Comment: This class corresponds to the FRBR group three entity 'Event'.@en  <br/>
     */
    public static final URI Event = new URIImpl("http://purl.org/vocab/frbr/core#Event");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: object@en  <br/>
     * Comment: This class corresponds to the FRBR group three entity 'Object'.@en  <br/>
     */
    public static final URI Object = new URIImpl("http://purl.org/vocab/frbr/core#Object");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: place@en  <br/>
     * Comment: This class corresponds to the FRBR group three entity 'Place'.@en  <br/>
     */
    public static final URI Place = new URIImpl("http://purl.org/vocab/frbr/core#Place");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: concept@en  <br/>
     * Comment: This class corresponds to the FRBR group three entity 'Concept'.@en  <br/>
     */
    public static final URI Concept = new URIImpl("http://purl.org/vocab/frbr/core#Concept");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: classical work@en  <br/>
     */
    public static final URI ClassicalWork = new URIImpl("http://purl.org/vocab/frbr/core#ClassicalWork");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: legal work@en  <br/>
     */
    public static final URI LegalWork = new URIImpl("http://purl.org/vocab/frbr/core#LegalWork");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: literary work@en  <br/>
     */
    public static final URI LiteraryWork = new URIImpl("http://purl.org/vocab/frbr/core#LiteraryWork");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: scholarly work@en  <br/>
     */
    public static final URI ScholarlyWork = new URIImpl("http://purl.org/vocab/frbr/core#ScholarlyWork");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: text@en  <br/>
     */
    public static final URI Text = new URIImpl("http://purl.org/vocab/frbr/core#Text");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: image@en  <br/>
     */
    public static final URI Image = new URIImpl("http://purl.org/vocab/frbr/core#Image");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: sound@en  <br/>
     */
    public static final URI Sound = new URIImpl("http://purl.org/vocab/frbr/core#Sound");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: moving image@en  <br/>
     */
    public static final URI MovingImage = new URIImpl("http://purl.org/vocab/frbr/core#MovingImage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: data@en  <br/>
     */
    public static final URI Data = new URIImpl("http://purl.org/vocab/frbr/core#Data");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: performance@en  <br/>
     */
    public static final URI Performance = new URIImpl("http://purl.org/vocab/frbr/core#Performance");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: related endeavour@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Endeavour  <br/>
     * Range: http://purl.org/vocab/frbr/core#Endeavour  <br/>
     */
    public static final URI relatedEndeavour = new URIImpl("http://purl.org/vocab/frbr/core#relatedEndeavour");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: realization@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Work  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI realization = new URIImpl("http://purl.org/vocab/frbr/core#realization");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: realization of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Work  <br/>
     */
    public static final URI realizationOf = new URIImpl("http://purl.org/vocab/frbr/core#realizationOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: embodiment@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     */
    public static final URI embodiment = new URIImpl("http://purl.org/vocab/frbr/core#embodiment");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: embodiment of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI embodimentOf = new URIImpl("http://purl.org/vocab/frbr/core#embodimentOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: exemplar@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     * Range: http://purl.org/vocab/frbr/core#Item  <br/>
     */
    public static final URI exemplar = new URIImpl("http://purl.org/vocab/frbr/core#exemplar");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: exemplar of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Item  <br/>
     * Range: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     */
    public static final URI exemplarOf = new URIImpl("http://purl.org/vocab/frbr/core#exemplarOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: reproduction@en  <br/>
     * Domain: _:node15fkfpv7qx79  <br/>
     * Range: _:node15fkfpv7qx80  <br/>
     */
    public static final URI reproduction = new URIImpl("http://purl.org/vocab/frbr/core#reproduction");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: reproduction of@en  <br/>
     * Domain: _:node15fkfpv7qx88  <br/>
     * Range: _:node15fkfpv7qx89  <br/>
     */
    public static final URI reproductionOf = new URIImpl("http://purl.org/vocab/frbr/core#reproductionOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: successor@en  <br/>
     * Domain: _:node15fkfpv7qx97  <br/>
     * Range: _:node15fkfpv7qx98  <br/>
     */
    public static final URI successor = new URIImpl("http://purl.org/vocab/frbr/core#successor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: successor of@en  <br/>
     * Domain: _:node15fkfpv7qx106  <br/>
     * Range: _:node15fkfpv7qx107  <br/>
     */
    public static final URI successorOf = new URIImpl("http://purl.org/vocab/frbr/core#successorOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: supplement@en  <br/>
     * Domain: _:node15fkfpv7qx115  <br/>
     * Range: _:node15fkfpv7qx116  <br/>
     */
    public static final URI supplement = new URIImpl("http://purl.org/vocab/frbr/core#supplement");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: supplement of@en  <br/>
     * Domain: _:node15fkfpv7qx124  <br/>
     * Range: _:node15fkfpv7qx125  <br/>
     */
    public static final URI supplementOf = new URIImpl("http://purl.org/vocab/frbr/core#supplementOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: complement@en  <br/>
     * Domain: _:node15fkfpv7qx133  <br/>
     * Range: _:node15fkfpv7qx134  <br/>
     */
    public static final URI complement = new URIImpl("http://purl.org/vocab/frbr/core#complement");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: complement of@en  <br/>
     * Domain: _:node15fkfpv7qx142  <br/>
     * Range: _:node15fkfpv7qx143  <br/>
     */
    public static final URI complementOf = new URIImpl("http://purl.org/vocab/frbr/core#complementOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: summarization@en  <br/>
     * Domain: _:node15fkfpv7qx151  <br/>
     * Range: _:node15fkfpv7qx152  <br/>
     */
    public static final URI summarization = new URIImpl("http://purl.org/vocab/frbr/core#summarization");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: summarization of@en  <br/>
     * Domain: _:node15fkfpv7qx160  <br/>
     * Range: _:node15fkfpv7qx161  <br/>
     */
    public static final URI summarizationOf = new URIImpl("http://purl.org/vocab/frbr/core#summarizationOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: adaption@en  <br/>
     * Domain: _:node15fkfpv7qx169  <br/>
     * Range: _:node15fkfpv7qx170  <br/>
     */
    public static final URI adaption = new URIImpl("http://purl.org/vocab/frbr/core#adaption");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: adaption of@en  <br/>
     * Domain: _:node15fkfpv7qx178  <br/>
     * Range: _:node15fkfpv7qx179  <br/>
     */
    public static final URI adaptionOf = new URIImpl("http://purl.org/vocab/frbr/core#adaptionOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: transformation@en  <br/>
     * Domain: _:node15fkfpv7qx187  <br/>
     * Range: _:node15fkfpv7qx188  <br/>
     */
    public static final URI transformation = new URIImpl("http://purl.org/vocab/frbr/core#transformation");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: transformation of@en  <br/>
     * Domain: _:node15fkfpv7qx196  <br/>
     * Range: _:node15fkfpv7qx197  <br/>
     */
    public static final URI transformationOf = new URIImpl("http://purl.org/vocab/frbr/core#transformationOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: imitation@en  <br/>
     * Domain: _:node15fkfpv7qx205  <br/>
     * Range: _:node15fkfpv7qx206  <br/>
     */
    public static final URI imitation = new URIImpl("http://purl.org/vocab/frbr/core#imitation");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: imitation of@en  <br/>
     * Domain: _:node15fkfpv7qx214  <br/>
     * Range: _:node15fkfpv7qx215  <br/>
     */
    public static final URI imitationOf = new URIImpl("http://purl.org/vocab/frbr/core#imitationOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: abridgement@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI abridgement = new URIImpl("http://purl.org/vocab/frbr/core#abridgement");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: abridgement of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI abridgementOf = new URIImpl("http://purl.org/vocab/frbr/core#abridgementOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: revision@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI revision = new URIImpl("http://purl.org/vocab/frbr/core#revision");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: revision of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI revisionOf = new URIImpl("http://purl.org/vocab/frbr/core#revisionOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: translation@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI translation = new URIImpl("http://purl.org/vocab/frbr/core#translation");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: translation of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI translationOf = new URIImpl("http://purl.org/vocab/frbr/core#translationOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: arrangement@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI arrangement = new URIImpl("http://purl.org/vocab/frbr/core#arrangement");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: arrangement of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI arrangementOf = new URIImpl("http://purl.org/vocab/frbr/core#arrangementOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: alternate@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     * Range: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     */
    public static final URI alternate = new URIImpl("http://purl.org/vocab/frbr/core#alternate");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: alternate of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     * Range: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     */
    public static final URI alternateOf = new URIImpl("http://purl.org/vocab/frbr/core#alternateOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: reconfiguration@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Item  <br/>
     * Range: http://purl.org/vocab/frbr/core#Item  <br/>
     */
    public static final URI reconfiguration = new URIImpl("http://purl.org/vocab/frbr/core#reconfiguration");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: reconfiguration of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Item  <br/>
     * Range: http://purl.org/vocab/frbr/core#Item  <br/>
     */
    public static final URI reconfigurationOf = new URIImpl("http://purl.org/vocab/frbr/core#reconfigurationOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: part@en  <br/>
     */
    public static final URI part = new URIImpl("http://purl.org/vocab/frbr/core#part");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: part of@en  <br/>
     */
    public static final URI partOf = new URIImpl("http://purl.org/vocab/frbr/core#partOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: responsible entity@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Endeavour  <br/>
     * Range: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     */
    public static final URI responsibleEntity = new URIImpl("http://purl.org/vocab/frbr/core#responsibleEntity");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: responsible entity of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     * Range: http://purl.org/vocab/frbr/core#Endeavour  <br/>
     */
    public static final URI responsibleEntityOf = new URIImpl("http://purl.org/vocab/frbr/core#responsibleEntityOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: creator@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Work  <br/>
     * Range: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     */
    public static final URI creator = new URIImpl("http://purl.org/vocab/frbr/core#creator");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: creator of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     * Range: http://purl.org/vocab/frbr/core#Work  <br/>
     */
    public static final URI creatorOf = new URIImpl("http://purl.org/vocab/frbr/core#creatorOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: realizer@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     */
    public static final URI realizer = new URIImpl("http://purl.org/vocab/frbr/core#realizer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: realizer of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI realizerOf = new URIImpl("http://purl.org/vocab/frbr/core#realizerOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: producer@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     * Range: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     */
    public static final URI producer = new URIImpl("http://purl.org/vocab/frbr/core#producer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: producer of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     * Range: http://purl.org/vocab/frbr/core#Manifestation  <br/>
     */
    public static final URI producerOf = new URIImpl("http://purl.org/vocab/frbr/core#producerOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: owner@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Item  <br/>
     * Range: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     */
    public static final URI owner = new URIImpl("http://purl.org/vocab/frbr/core#owner");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: owner of@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#ResponsibleEntity  <br/>
     * Range: http://purl.org/vocab/frbr/core#Item  <br/>
     */
    public static final URI ownerOf = new URIImpl("http://purl.org/vocab/frbr/core#ownerOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: subject@en  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Work  <br/>
     * Range: _:node15fkfpv7qx271  <br/>
     */
    public static final URI subject = new URIImpl("http://purl.org/vocab/frbr/core#subject");
}
