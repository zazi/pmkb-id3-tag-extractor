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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Mon Oct 25 11:26:07 CEST 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/dcterms.rdfs
 * namespace: http://purl.org/dc/terms/
 */
public class DCTERMS {

    /** Path to the ontology resource */
    public static final String DCTERMS_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/dcterms.rdfs";

    /**
     * Puts the DCTERMS ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getDCTERMSOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(DCTERMS_RESOURCE_PATH, DCTERMS.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + DCTERMS_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for DCTERMS */
    public static final URI NS_DCTERMS = new URIImpl("http://purl.org/dc/terms/");
    /**
     * Type: Instance of http://purl.org/dc/terms/AgentClass <br/>
     * Label: Agent@en-us  <br/>
     * Comment: A resource that acts or has the power to act.@en-us  <br/>
     */
    public static final URI Agent = new URIImpl("http://purl.org/dc/terms/Agent");
    /**
     * Type: Class <br/>
     * Label: Agent Class@en-us  <br/>
     * Comment: A group of agents.@en-us  <br/>
     */
    public static final URI AgentClass = new URIImpl("http://purl.org/dc/terms/AgentClass");
    /**
     * Type: Class <br/>
     * Label: Bibliographic Resource@en-us  <br/>
     * Comment: A book, article, or other documentary resource.@en-us  <br/>
     */
    public static final URI BibliographicResource = new URIImpl("http://purl.org/dc/terms/BibliographicResource");
    /**
     * Type: Class <br/>
     * Label: File Format@en-us  <br/>
     * Comment: A digital resource format.@en-us  <br/>
     */
    public static final URI FileFormat = new URIImpl("http://purl.org/dc/terms/FileFormat");
    /**
     * Type: Class <br/>
     * Label: Frequency@en-us  <br/>
     * Comment: A rate at which something recurs.@en-us  <br/>
     */
    public static final URI Frequency = new URIImpl("http://purl.org/dc/terms/Frequency");
    /**
     * Type: Class <br/>
     * Label: Jurisdiction@en-us  <br/>
     * Comment: The extent or range of judicial, law enforcement, or other authority.@en-us  <br/>
     */
    public static final URI Jurisdiction = new URIImpl("http://purl.org/dc/terms/Jurisdiction");
    /**
     * Type: Class <br/>
     * Label: License Document@en-us  <br/>
     * Comment: A legal document giving official permission to do something with a Resource.@en-us  <br/>
     */
    public static final URI LicenseDocument = new URIImpl("http://purl.org/dc/terms/LicenseDocument");
    /**
     * Type: Class <br/>
     * Label: Linguistic System@en-us  <br/>
     * Comment: A system of signs, symbols, sounds, gestures, or rules used in communication.@en-us  <br/>
     */
    public static final URI LinguisticSystem = new URIImpl("http://purl.org/dc/terms/LinguisticSystem");
    /**
     * Type: Class <br/>
     * Label: Location@en-us  <br/>
     * Comment: A spatial region or named place.@en-us  <br/>
     */
    public static final URI Location = new URIImpl("http://purl.org/dc/terms/Location");
    /**
     * Type: Class <br/>
     * Label: Location, Period, or Jurisdiction@en-us  <br/>
     * Comment: A location, period of time, or jurisdiction.@en-us  <br/>
     */
    public static final URI LocationPeriodOrJurisdiction = new URIImpl("http://purl.org/dc/terms/LocationPeriodOrJurisdiction");
    /**
     * Type: Class <br/>
     * Label: Media Type@en-us  <br/>
     * Comment: A file format or physical medium.@en-us  <br/>
     */
    public static final URI MediaType = new URIImpl("http://purl.org/dc/terms/MediaType");
    /**
     * Type: Class <br/>
     * Label: Media Type or Extent@en-us  <br/>
     * Comment: A media type or extent.@en-us  <br/>
     */
    public static final URI MediaTypeOrExtent = new URIImpl("http://purl.org/dc/terms/MediaTypeOrExtent");
    /**
     * Type: Class <br/>
     * Label: Method of Instruction@en-us  <br/>
     * Comment: A process that is used to engender knowledge, attitudes, and skills.@en-us  <br/>
     */
    public static final URI MethodOfInstruction = new URIImpl("http://purl.org/dc/terms/MethodOfInstruction");
    /**
     * Type: Class <br/>
     * Label: Method of Accrual@en-us  <br/>
     * Comment: A method by which resources are added to a collection.@en-us  <br/>
     */
    public static final URI MethodOfAccrual = new URIImpl("http://purl.org/dc/terms/MethodOfAccrual");
    /**
     * Type: Class <br/>
     * Label: Period of Time@en-us  <br/>
     * Comment: An interval of time that is named or defined by its start and end dates.@en-us  <br/>
     */
    public static final URI PeriodOfTime = new URIImpl("http://purl.org/dc/terms/PeriodOfTime");
    /**
     * Type: Class <br/>
     * Label: Physical Medium@en-us  <br/>
     * Comment: A physical material or carrier.@en-us  <br/>
     */
    public static final URI PhysicalMedium = new URIImpl("http://purl.org/dc/terms/PhysicalMedium");
    /**
     * Type: Class <br/>
     * Label: Physical Resource@en-us  <br/>
     * Comment: A material thing.@en-us  <br/>
     */
    public static final URI PhysicalResource = new URIImpl("http://purl.org/dc/terms/PhysicalResource");
    /**
     * Type: Class <br/>
     * Label: Policy@en-us  <br/>
     * Comment: A plan or course of action by an authority, intended to influence and determine decisions, actions, and other matters.@en-us  <br/>
     */
    public static final URI Policy = new URIImpl("http://purl.org/dc/terms/Policy");
    /**
     * Type: Class <br/>
     * Label: Provenance Statement@en-us  <br/>
     * Comment: A statement of any changes in ownership and custody of a resource since its creation that are significant for its authenticity, integrity, and interpretation.@en-us  <br/>
     */
    public static final URI ProvenanceStatement = new URIImpl("http://purl.org/dc/terms/ProvenanceStatement");
    /**
     * Type: Class <br/>
     * Label: Rights Statement@en-us  <br/>
     * Comment: A statement about the intellectual property rights (IPR) held in or over a Resource, a legal document giving official permission to do something with a resource, or a statement about access rights.@en-us  <br/>
     */
    public static final URI RightsStatement = new URIImpl("http://purl.org/dc/terms/RightsStatement");
    /**
     * Type: Class <br/>
     * Label: Size or Duration@en-us  <br/>
     * Comment: A dimension or extent, or a time taken to play or execute.@en-us  <br/>
     */
    public static final URI SizeOrDuration = new URIImpl("http://purl.org/dc/terms/SizeOrDuration");
    /**
     * Type: Class <br/>
     * Label: Standard@en-us  <br/>
     * Comment: A basis for comparison; a reference point against which other things can be evaluated.@en-us  <br/>
     */
    public static final URI Standard = new URIImpl("http://purl.org/dc/terms/Standard");
    /**
     * Type: Property <br/>
     * Label: Title@en-us  <br/>
     * Comment: A name given to the resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI title = new URIImpl("http://purl.org/dc/terms/title");
    /**
     * Type: Property <br/>
     * Label: Creator@en-us  <br/>
     * Comment: An entity primarily responsible for making the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/Agent  <br/>
     */
    public static final URI creator = new URIImpl("http://purl.org/dc/terms/creator");
    /**
     * Type: Property <br/>
     * Label: Subject@en-us  <br/>
     * Comment: The topic of the resource.@en-us  <br/>
     */
    public static final URI subject = new URIImpl("http://purl.org/dc/terms/subject");
    /**
     * Type: Property <br/>
     * Label: Description@en-us  <br/>
     * Comment: An account of the resource.@en-us  <br/>
     */
    public static final URI description = new URIImpl("http://purl.org/dc/terms/description");
    /**
     * Type: Property <br/>
     * Label: Publisher@en-us  <br/>
     * Comment: An entity responsible for making the resource available.@en-us  <br/>
     * Range: http://purl.org/dc/terms/Agent  <br/>
     */
    public static final URI publisher = new URIImpl("http://purl.org/dc/terms/publisher");
    /**
     * Type: Property <br/>
     * Label: Contributor@en-us  <br/>
     * Comment: An entity responsible for making contributions to the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/Agent  <br/>
     */
    public static final URI contributor = new URIImpl("http://purl.org/dc/terms/contributor");
    /**
     * Type: Property <br/>
     * Label: Date@en-us  <br/>
     * Comment: A point or period of time associated with an event in the lifecycle of the resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI date = new URIImpl("http://purl.org/dc/terms/date");
    /**
     * Type: Property <br/>
     * Label: Type@en-us  <br/>
     * Comment: The nature or genre of the resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Class  <br/>
     */
    public static final URI type = new URIImpl("http://purl.org/dc/terms/type");
    /**
     * Type: Property <br/>
     * Label: Format@en-us  <br/>
     * Comment: The file format, physical medium, or dimensions of the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/MediaTypeOrExtent  <br/>
     */
    public static final URI format = new URIImpl("http://purl.org/dc/terms/format");
    /**
     * Type: Property <br/>
     * Label: Identifier@en-us  <br/>
     * Comment: An unambiguous reference to the resource within a given context.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI identifier = new URIImpl("http://purl.org/dc/terms/identifier");
    /**
     * Type: Property <br/>
     * Label: Source@en-us  <br/>
     * Comment: A related resource from which the described resource is derived.@en-us  <br/>
     */
    public static final URI source = new URIImpl("http://purl.org/dc/terms/source");
    /**
     * Type: Property <br/>
     * Label: Language@en-us  <br/>
     * Comment: A language of the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/LinguisticSystem  <br/>
     */
    public static final URI language = new URIImpl("http://purl.org/dc/terms/language");
    /**
     * Type: Property <br/>
     * Label: Relation@en-us  <br/>
     * Comment: A related resource.@en-us  <br/>
     */
    public static final URI relation = new URIImpl("http://purl.org/dc/terms/relation");
    /**
     * Type: Property <br/>
     * Label: Coverage@en-us  <br/>
     * Comment: The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.@en-us  <br/>
     * Range: http://purl.org/dc/terms/LocationPeriodOrJurisdiction  <br/>
     */
    public static final URI coverage = new URIImpl("http://purl.org/dc/terms/coverage");
    /**
     * Type: Property <br/>
     * Label: Rights@en-us  <br/>
     * Comment: Information about rights held in and over the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/RightsStatement  <br/>
     */
    public static final URI rights = new URIImpl("http://purl.org/dc/terms/rights");
    /**
     * Type: Property <br/>
     * Label: Audience@en-us  <br/>
     * Comment: A class of entity for whom the resource is intended or useful.@en-us  <br/>
     * Range: http://purl.org/dc/terms/AgentClass  <br/>
     */
    public static final URI audience = new URIImpl("http://purl.org/dc/terms/audience");
    /**
     * Type: Property <br/>
     * Label: Alternative Title@en-us  <br/>
     * Comment: An alternative name for the resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI alternative = new URIImpl("http://purl.org/dc/terms/alternative");
    /**
     * Type: Property <br/>
     * Label: Table Of Contents@en-us  <br/>
     * Comment: A list of subunits of the resource.@en-us  <br/>
     */
    public static final URI tableOfContents = new URIImpl("http://purl.org/dc/terms/tableOfContents");
    /**
     * Type: Property <br/>
     * Label: Abstract@en-us  <br/>
     * Comment: A summary of the resource.@en-us  <br/>
     */
    public static final URI abstract_ = new URIImpl("http://purl.org/dc/terms/abstract");
    /**
     * Type: Property <br/>
     * Label: Date Created@en-us  <br/>
     * Comment: Date of creation of the resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI created = new URIImpl("http://purl.org/dc/terms/created");
    /**
     * Type: Property <br/>
     * Label: Date Valid@en-us  <br/>
     * Comment: Date (often a range) of validity of a resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI valid = new URIImpl("http://purl.org/dc/terms/valid");
    /**
     * Type: Property <br/>
     * Label: Date Available@en-us  <br/>
     * Comment: Date (often a range) that the resource became or will become available.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI available = new URIImpl("http://purl.org/dc/terms/available");
    /**
     * Type: Property <br/>
     * Label: Date Issued@en-us  <br/>
     * Comment: Date of formal issuance (e.g., publication) of the resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI issued = new URIImpl("http://purl.org/dc/terms/issued");
    /**
     * Type: Property <br/>
     * Label: Date Modified@en-us  <br/>
     * Comment: Date on which the resource was changed.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI modified = new URIImpl("http://purl.org/dc/terms/modified");
    /**
     * Type: Property <br/>
     * Label: Extent@en-us  <br/>
     * Comment: The size or duration of the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/SizeOrDuration  <br/>
     */
    public static final URI extent = new URIImpl("http://purl.org/dc/terms/extent");
    /**
     * Type: Property <br/>
     * Label: Medium@en-us  <br/>
     * Comment: The material or physical carrier of the resource.@en-us  <br/>
     * Domain: http://purl.org/dc/terms/PhysicalResource  <br/>
     * Range: http://purl.org/dc/terms/PhysicalMedium  <br/>
     */
    public static final URI medium = new URIImpl("http://purl.org/dc/terms/medium");
    /**
     * Type: Property <br/>
     * Label: Is Version Of@en-us  <br/>
     * Comment: A related resource of which the described resource is a version, edition, or adaptation.@en-us  <br/>
     */
    public static final URI isVersionOf = new URIImpl("http://purl.org/dc/terms/isVersionOf");
    /**
     * Type: Property <br/>
     * Label: Has Version@en-us  <br/>
     * Comment: A related resource that is a version, edition, or adaptation of the described resource.@en-us  <br/>
     */
    public static final URI hasVersion = new URIImpl("http://purl.org/dc/terms/hasVersion");
    /**
     * Type: Property <br/>
     * Label: Is Replaced By@en-us  <br/>
     * Comment: A related resource that supplants, displaces, or supersedes the described resource.@en-us  <br/>
     */
    public static final URI isReplacedBy = new URIImpl("http://purl.org/dc/terms/isReplacedBy");
    /**
     * Type: Property <br/>
     * Label: Replaces@en-us  <br/>
     * Comment: A related resource that is supplanted, displaced, or superseded by the described resource.@en-us  <br/>
     */
    public static final URI replaces = new URIImpl("http://purl.org/dc/terms/replaces");
    /**
     * Type: Property <br/>
     * Label: Is Required By@en-us  <br/>
     * Comment: A related resource that requires the described resource to support its function, delivery, or coherence.@en-us  <br/>
     */
    public static final URI isRequiredBy = new URIImpl("http://purl.org/dc/terms/isRequiredBy");
    /**
     * Type: Property <br/>
     * Label: Requires@en-us  <br/>
     * Comment: A related resource that is required by the described resource to support its function, delivery, or coherence.@en-us  <br/>
     */
    public static final URI requires = new URIImpl("http://purl.org/dc/terms/requires");
    /**
     * Type: Property <br/>
     * Label: Is Part Of@en-us  <br/>
     * Comment: A related resource in which the described resource is physically or logically included.@en-us  <br/>
     */
    public static final URI isPartOf = new URIImpl("http://purl.org/dc/terms/isPartOf");
    /**
     * Type: Property <br/>
     * Label: Has Part@en-us  <br/>
     * Comment: A related resource that is included either physically or logically in the described resource.@en-us  <br/>
     */
    public static final URI hasPart = new URIImpl("http://purl.org/dc/terms/hasPart");
    /**
     * Type: Property <br/>
     * Label: Is Referenced By@en-us  <br/>
     * Comment: A related resource that references, cites, or otherwise points to the described resource.@en-us  <br/>
     */
    public static final URI isReferencedBy = new URIImpl("http://purl.org/dc/terms/isReferencedBy");
    /**
     * Type: Property <br/>
     * Label: References@en-us  <br/>
     * Comment: A related resource that is referenced, cited, or otherwise pointed to by the described resource.@en-us  <br/>
     */
    public static final URI references = new URIImpl("http://purl.org/dc/terms/references");
    /**
     * Type: Property <br/>
     * Label: Is Format Of@en-us  <br/>
     * Comment: A related resource that is substantially the same as the described resource, but in another format.@en-us  <br/>
     */
    public static final URI isFormatOf = new URIImpl("http://purl.org/dc/terms/isFormatOf");
    /**
     * Type: Property <br/>
     * Label: Has Format@en-us  <br/>
     * Comment: A related resource that is substantially the same as the pre-existing described resource, but in another format.@en-us  <br/>
     */
    public static final URI hasFormat = new URIImpl("http://purl.org/dc/terms/hasFormat");
    /**
     * Type: Property <br/>
     * Label: Conforms To@en-us  <br/>
     * Comment: An established standard to which the described resource conforms.@en-us  <br/>
     * Range: http://purl.org/dc/terms/Standard  <br/>
     */
    public static final URI conformsTo = new URIImpl("http://purl.org/dc/terms/conformsTo");
    /**
     * Type: Property <br/>
     * Label: Spatial Coverage@en-us  <br/>
     * Comment: Spatial characteristics of the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/Location  <br/>
     */
    public static final URI spatial = new URIImpl("http://purl.org/dc/terms/spatial");
    /**
     * Type: Property <br/>
     * Label: Temporal Coverage@en-us  <br/>
     * Comment: Temporal characteristics of the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/PeriodOfTime  <br/>
     */
    public static final URI temporal = new URIImpl("http://purl.org/dc/terms/temporal");
    /**
     * Type: Property <br/>
     * Label: Mediator@en-us  <br/>
     * Comment: An entity that mediates access to the resource and for whom the resource is intended or useful.@en-us  <br/>
     * Range: http://purl.org/dc/terms/AgentClass  <br/>
     */
    public static final URI mediator = new URIImpl("http://purl.org/dc/terms/mediator");
    /**
     * Type: Property <br/>
     * Label: Date Accepted@en-us  <br/>
     * Comment: Date of acceptance of the resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI dateAccepted = new URIImpl("http://purl.org/dc/terms/dateAccepted");
    /**
     * Type: Property <br/>
     * Label: Date Copyrighted@en-us  <br/>
     * Comment: Date of copyright.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI dateCopyrighted = new URIImpl("http://purl.org/dc/terms/dateCopyrighted");
    /**
     * Type: Property <br/>
     * Label: Date Submitted@en-us  <br/>
     * Comment: Date of submission of the resource.@en-us  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI dateSubmitted = new URIImpl("http://purl.org/dc/terms/dateSubmitted");
    /**
     * Type: Property <br/>
     * Label: Audience Education Level@en-us  <br/>
     * Comment: A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.@en-us  <br/>
     * Range: http://purl.org/dc/terms/AgentClass  <br/>
     */
    public static final URI educationLevel = new URIImpl("http://purl.org/dc/terms/educationLevel");
    /**
     * Type: Property <br/>
     * Label: Access Rights@en-us  <br/>
     * Comment: Information about who can access the resource or an indication of its security status.@en-us  <br/>
     * Range: http://purl.org/dc/terms/RightsStatement  <br/>
     */
    public static final URI accessRights = new URIImpl("http://purl.org/dc/terms/accessRights");
    /**
     * Type: Property <br/>
     * Label: Bibliographic Citation@en-us  <br/>
     * Comment: A bibliographic reference for the resource.@en-us  <br/>
     * Domain: http://purl.org/dc/terms/BibliographicResource  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI bibliographicCitation = new URIImpl("http://purl.org/dc/terms/bibliographicCitation");
    /**
     * Type: Property <br/>
     * Label: License@en-us  <br/>
     * Comment: A legal document giving official permission to do something with the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/LicenseDocument  <br/>
     */
    public static final URI license = new URIImpl("http://purl.org/dc/terms/license");
    /**
     * Type: Property <br/>
     * Label: Rights Holder@en-us  <br/>
     * Comment: A person or organization owning or managing rights over the resource.@en-us  <br/>
     * Range: http://purl.org/dc/terms/Agent  <br/>
     */
    public static final URI rightsHolder = new URIImpl("http://purl.org/dc/terms/rightsHolder");
    /**
     * Type: Property <br/>
     * Label: Provenance@en-us  <br/>
     * Comment: A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.@en-us  <br/>
     * Range: http://purl.org/dc/terms/ProvenanceStatement  <br/>
     */
    public static final URI provenance = new URIImpl("http://purl.org/dc/terms/provenance");
    /**
     * Type: Property <br/>
     * Label: Instructional Method@en-us  <br/>
     * Comment: A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.@en-us  <br/>
     * Range: http://purl.org/dc/terms/MethodOfInstruction  <br/>
     */
    public static final URI instructionalMethod = new URIImpl("http://purl.org/dc/terms/instructionalMethod");
    /**
     * Type: Property <br/>
     * Label: Accrual Method@en-us  <br/>
     * Comment: The method by which items are added to a collection.@en-us  <br/>
     * Domain: http://purl.org/dc/dcmitype/Collection  <br/>
     * Range: http://purl.org/dc/terms/MethodOfAccrual  <br/>
     */
    public static final URI accrualMethod = new URIImpl("http://purl.org/dc/terms/accrualMethod");
    /**
     * Type: Property <br/>
     * Label: Accrual Periodicity@en-us  <br/>
     * Comment: The frequency with which items are added to a collection.@en-us  <br/>
     * Domain: http://purl.org/dc/dcmitype/Collection  <br/>
     * Range: http://purl.org/dc/terms/Frequency  <br/>
     */
    public static final URI accrualPeriodicity = new URIImpl("http://purl.org/dc/terms/accrualPeriodicity");
    /**
     * Type: Property <br/>
     * Label: Accrual Policy@en-us  <br/>
     * Comment: The policy governing the addition of items to a collection.@en-us  <br/>
     * Domain: http://purl.org/dc/dcmitype/Collection  <br/>
     * Range: http://purl.org/dc/terms/Policy  <br/>
     */
    public static final URI accrualPolicy = new URIImpl("http://purl.org/dc/terms/accrualPolicy");
}
