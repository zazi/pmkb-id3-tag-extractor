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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Tue Nov 02 21:32:56 CET 2010
 * input file: /workspacePMKB/pmkb/src/main/resources/smiy/pmkb/vocabulary/bibo.owl
 * namespace: http://purl.org/ontology/bibo/
 */
public class BIBO {

    /** Path to the ontology resource */
    public static final String BIBO_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/bibo.owl";

    /**
     * Puts the BIBO ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getBIBOOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(BIBO_RESOURCE_PATH, BIBO.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + BIBO_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for BIBO */
    public static final URI NS_BIBO = new URIImpl("http://purl.org/ontology/bibo/");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Academic Article@en  <br/>
     * Comment: A scholarly academic article, typically published in a journal.@en  <br/>
     */
    public static final URI AcademicArticle = new URIImpl("http://purl.org/ontology/bibo/AcademicArticle");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Article@en  <br/>
     * Comment: A written composition in prose, usually nonfiction, on a specific topic, forming an independent part of a book or other publication, as a newspaper or magazine.@en  <br/>
     */
    public static final URI Article = new URIImpl("http://purl.org/ontology/bibo/Article");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: audio document@en  <br/>
     * Comment: An audio document; aka record.@en  <br/>
     */
    public static final URI AudioDocument = new URIImpl("http://purl.org/ontology/bibo/AudioDocument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: audio-visual document@en  <br/>
     * Comment: An audio-visual document; film, video, and so forth.@en  <br/>
     */
    public static final URI AudioVisualDocument = new URIImpl("http://purl.org/ontology/bibo/AudioVisualDocument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Bill@en  <br/>
     * Comment: Draft legislation presented for discussion to a legal body.@en  <br/>
     */
    public static final URI Bill = new URIImpl("http://purl.org/ontology/bibo/Bill");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Book@en  <br/>
     * Comment: A written or printed work of fiction or nonfiction, usually on sheets of paper fastened or bound together within covers.@en  <br/>
     */
    public static final URI Book = new URIImpl("http://purl.org/ontology/bibo/Book");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Book Section@en  <br/>
     * Comment: A section of a book.@en  <br/>
     */
    public static final URI BookSection = new URIImpl("http://purl.org/ontology/bibo/BookSection");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Brief@en  <br/>
     * Comment: A written argument submitted to a court.@en  <br/>
     */
    public static final URI Brief = new URIImpl("http://purl.org/ontology/bibo/Brief");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Chapter@en  <br/>
     * Comment: A chapter of a book.@en  <br/>
     */
    public static final URI Chapter = new URIImpl("http://purl.org/ontology/bibo/Chapter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Code@en  <br/>
     * Comment: A collection of statutes.@en  <br/>
     */
    public static final URI Code = new URIImpl("http://purl.org/ontology/bibo/Code");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Collected Document@en  <br/>
     * Comment: A document that simultaneously contains other documents.@en  <br/>
     */
    public static final URI CollectedDocument = new URIImpl("http://purl.org/ontology/bibo/CollectedDocument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Collection@en  <br/>
     * Comment: A collection of Documents or Collections@en  <br/>
     */
    public static final URI Collection = new URIImpl("http://purl.org/ontology/bibo/Collection");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Conference@en  <br/>
     * Comment: A meeting for consultation or discussion.@en  <br/>
     */
    public static final URI Conference = new URIImpl("http://purl.org/ontology/bibo/Conference");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Court Reporter@en  <br/>
     * Comment: A collection of legal cases.@en  <br/>
     */
    public static final URI CourtReporter = new URIImpl("http://purl.org/ontology/bibo/CourtReporter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Document@en  <br/>
     * Comment: A document (noun) is a bounded physical representation of body of information designed with the capacity (and usually intent) to communicate. A document may manifest symbolic, diagrammatic or sensory-representational information.@en  <br/>
     */
    public static final URI Document = new URIImpl("http://purl.org/ontology/bibo/Document");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: document part@en  <br/>
     * Comment: a distinct part of a larger document or collected document.@en  <br/>
     */
    public static final URI DocumentPart = new URIImpl("http://purl.org/ontology/bibo/DocumentPart");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Document Status@en  <br/>
     * Comment: The status of the publication of a document.@en  <br/>
     */
    public static final URI DocumentStatus = new URIImpl("http://purl.org/ontology/bibo/DocumentStatus");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Edited Book@en  <br/>
     * Comment: An edited book.@en  <br/>
     */
    public static final URI EditedBook = new URIImpl("http://purl.org/ontology/bibo/EditedBook");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: EMail@en  <br/>
     * Comment: A written communication addressed to a person or organization and transmitted electronically.@en  <br/>
     */
    public static final URI Email = new URIImpl("http://purl.org/ontology/bibo/Email");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI Event = new URIImpl("http://purl.org/ontology/bibo/Event");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Excerpt@en  <br/>
     * Comment: A passage selected from a larger work.@en  <br/>
     */
    public static final URI Excerpt = new URIImpl("http://purl.org/ontology/bibo/Excerpt");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Film@en  <br/>
     * Comment: aka movie.@en  <br/>
     */
    public static final URI Film = new URIImpl("http://purl.org/ontology/bibo/Film");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Hearing@en  <br/>
     * Comment: An instance or a session in which testimony and arguments are presented, esp. before an official, as a judge in a lawsuit.@en  <br/>
     */
    public static final URI Hearing = new URIImpl("http://purl.org/ontology/bibo/Hearing");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Image@en  <br/>
     * Comment: A document that presents visual or diagrammatic information.@en  <br/>
     */
    public static final URI Image = new URIImpl("http://purl.org/ontology/bibo/Image");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Interview@en  <br/>
     * Comment: A formalized discussion between two or more people.@en  <br/>
     */
    public static final URI Interview = new URIImpl("http://purl.org/ontology/bibo/Interview");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Issue@en  <br/>
     * Comment: something that is printed or published and distributed, esp. a given number of a periodical@en  <br/>
     */
    public static final URI Issue = new URIImpl("http://purl.org/ontology/bibo/Issue");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Journal@en  <br/>
     * Comment: A periodical of scholarly journal Articles.@en  <br/>
     */
    public static final URI Journal = new URIImpl("http://purl.org/ontology/bibo/Journal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Legal Case Document@en  <br/>
     * Comment: A document accompanying a legal case.@en  <br/>
     */
    public static final URI LegalCaseDocument = new URIImpl("http://purl.org/ontology/bibo/LegalCaseDocument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Decision@en  <br/>
     * Comment: A document containing an authoritative determination (as a decree or judgment) made after consideration of facts or law.@en  <br/>
     */
    public static final URI LegalDecision = new URIImpl("http://purl.org/ontology/bibo/LegalDecision");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Legal Document@en  <br/>
     * Comment: A legal document; for example, a court decision, a brief, and so forth.@en  <br/>
     */
    public static final URI LegalDocument = new URIImpl("http://purl.org/ontology/bibo/LegalDocument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Legislation@en  <br/>
     * Comment: A legal document proposing or enacting a law or a group of laws.@en  <br/>
     */
    public static final URI Legislation = new URIImpl("http://purl.org/ontology/bibo/Legislation");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Letter@en  <br/>
     * Comment: A written or printed communication addressed to a person or organization and usually transmitted by mail.@en  <br/>
     */
    public static final URI Letter = new URIImpl("http://purl.org/ontology/bibo/Letter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Magazine@en  <br/>
     * Comment: A periodical of magazine Articles. A magazine is a publication that is issued periodically, usually bound in a paper cover, and typically contains essays, stories, poems, etc., by many writers, and often photographs and drawings, frequently specializing in a particular subject or area, as hobbies, news, or sports.@en  <br/>
     */
    public static final URI Magazine = new URIImpl("http://purl.org/ontology/bibo/Magazine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Manual@en  <br/>
     * Comment: A small reference book, especially one giving instructions.@en  <br/>
     */
    public static final URI Manual = new URIImpl("http://purl.org/ontology/bibo/Manual");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Manuscript@en  <br/>
     * Comment: An unpublished Document, which may also be submitted to a publisher for publication.@en  <br/>
     */
    public static final URI Manuscript = new URIImpl("http://purl.org/ontology/bibo/Manuscript");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Map@en  <br/>
     * Comment: A graphical depiction of geographic features.@en  <br/>
     */
    public static final URI Map = new URIImpl("http://purl.org/ontology/bibo/Map");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Series@en  <br/>
     * Comment: A loose, thematic, collection of Documents, often Books.@en  <br/>
     */
    public static final URI MultiVolumeBook = new URIImpl("http://purl.org/ontology/bibo/MultiVolumeBook");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Newspaper@en  <br/>
     * Comment: A periodical of documents, usually issued daily or weekly, containing current news, editorials, feature articles, and usually advertising.@en  <br/>
     */
    public static final URI Newspaper = new URIImpl("http://purl.org/ontology/bibo/Newspaper");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Note@en  <br/>
     * Comment: Notes or annotations about a resource.@en  <br/>
     */
    public static final URI Note = new URIImpl("http://purl.org/ontology/bibo/Note");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Patent@en  <br/>
     * Comment: A document describing the exclusive right granted by a government to an inventor to manufacture, use, or sell an invention for a certain number of years.@en  <br/>
     */
    public static final URI Patent = new URIImpl("http://purl.org/ontology/bibo/Patent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Performance@en  <br/>
     * Comment: A public performance.@en  <br/>
     */
    public static final URI Performance = new URIImpl("http://purl.org/ontology/bibo/Performance");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Periodical@en  <br/>
     * Comment: A group of related documents issued at regular intervals.@en  <br/>
     */
    public static final URI Periodical = new URIImpl("http://purl.org/ontology/bibo/Periodical");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Personal Communication@en  <br/>
     * Comment: A communication between an agent and one or more specific recipients.@en  <br/>
     */
    public static final URI PersonalCommunication = new URIImpl("http://purl.org/ontology/bibo/PersonalCommunication");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Personal Communication Document@en  <br/>
     * Comment: A personal communication manifested in some document.@en  <br/>
     */
    public static final URI PersonalCommunicationDocument = new URIImpl("http://purl.org/ontology/bibo/PersonalCommunicationDocument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Proceedings@en  <br/>
     * Comment: A compilation of documents published from an event, such as a conference.@en  <br/>
     */
    public static final URI Proceedings = new URIImpl("http://purl.org/ontology/bibo/Proceedings");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Quote@en  <br/>
     * Comment: An excerpted collection of words.@en  <br/>
     */
    public static final URI Quote = new URIImpl("http://purl.org/ontology/bibo/Quote");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Reference Source@en  <br/>
     * Comment: A document that presents authoritative reference information, such as a dictionary or encylopedia .@en  <br/>
     */
    public static final URI ReferenceSource = new URIImpl("http://purl.org/ontology/bibo/ReferenceSource");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Report@en  <br/>
     * Comment: A document describing an account or statement describing in detail an event, situation, or the like, usually as the result of observation, inquiry, etc..@en  <br/>
     */
    public static final URI Report = new URIImpl("http://purl.org/ontology/bibo/Report");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Series@en  <br/>
     * Comment: A loose, thematic, collection of Documents, often Books.@en  <br/>
     */
    public static final URI Series = new URIImpl("http://purl.org/ontology/bibo/Series");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Slide@en  <br/>
     * Comment: A slide in a slideshow@en  <br/>
     */
    public static final URI Slide = new URIImpl("http://purl.org/ontology/bibo/Slide");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Slideshow@en  <br/>
     * Comment: A presentation of a series of slides, usually presented in front of an audience with written text and images.@en  <br/>
     */
    public static final URI Slideshow = new URIImpl("http://purl.org/ontology/bibo/Slideshow");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Standard@en  <br/>
     * Comment: A document describing a standard@en  <br/>
     */
    public static final URI Standard = new URIImpl("http://purl.org/ontology/bibo/Standard");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Statute@en  <br/>
     * Comment: A bill enacted into law.@en  <br/>
     */
    public static final URI Statute = new URIImpl("http://purl.org/ontology/bibo/Statute");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Thesis@en  <br/>
     * Comment: A document created to summarize research findings associated with the completion of an academic degree.@en  <br/>
     */
    public static final URI Thesis = new URIImpl("http://purl.org/ontology/bibo/Thesis");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Thesis degree@en  <br/>
     * Comment: The academic degree of a Thesis@en  <br/>
     */
    public static final URI ThesisDegree = new URIImpl("http://purl.org/ontology/bibo/ThesisDegree");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Webpage@en  <br/>
     * Comment: A web page is an online document available (at least initially) on the world wide web. A web page is written first and foremost to appear on the web, as distinct from other online resources such as books, manuscripts or audio documents which use the web primarily as a distribution mechanism alongside other more traditional methods such as print.@en  <br/>
     */
    public static final URI Webpage = new URIImpl("http://purl.org/ontology/bibo/Webpage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Website@en  <br/>
     * Comment: A group of Webpages accessible on the Web.@en  <br/>
     */
    public static final URI Website = new URIImpl("http://purl.org/ontology/bibo/Website");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Workshop@en  <br/>
     * Comment: A seminar, discussion group, or the like, that emphasizes zxchange of ideas and the demonstration and application of techniques, skills, etc.@en  <br/>
     */
    public static final URI Workshop = new URIImpl("http://purl.org/ontology/bibo/Workshop");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Thing <br/>
     * Label: accepted@en  <br/>
     * Comment: Accepted for publication after peer reviewing.@en  <br/>
     */
    public static final URI accepted = new URIImpl("http://purl.org/ontology/bibo/status/accepted");
    /**
     * Type: Instance of http://purl.org/ontology/bibo/DocumentStatus <br/>
     * Label: draft@en  <br/>
     * Comment: Document drafted@en  <br/>
     */
    public static final URI draft = new URIImpl("http://purl.org/ontology/bibo/status/draft");
    /**
     * Type: Instance of http://purl.org/ontology/bibo/DocumentStatus <br/>
     * Label: forthcoming@en  <br/>
     * Comment: Document to be published@en  <br/>
     */
    public static final URI forthcoming = new URIImpl("http://purl.org/ontology/bibo/status/forthcoming");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Thing <br/>
     * Label: legal@en  <br/>
     * Comment: Legal document@en  <br/>
     */
    public static final URI legal = new URIImpl("http://purl.org/ontology/bibo/status/legal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Thing <br/>
     * Label: non peer reviewed@en  <br/>
     * Comment: A document that is not peer reviewed@en  <br/>
     */
    public static final URI nonPeerReviewed = new URIImpl("http://purl.org/ontology/bibo/status/nonPeerReviewed");
    /**
     * Type: Instance of http://purl.org/ontology/bibo/DocumentStatus <br/>
     * Label: peer reviewed@en  <br/>
     * Comment: The process by which articles are chosen to be included in a refereed journal. An editorial board consisting of experts in the same field as the author review the article and decide if it is authoritative enough for publication.@en  <br/>
     */
    public static final URI peerReviewed = new URIImpl("http://purl.org/ontology/bibo/status/peerReviewed");
    /**
     * Type: Instance of http://purl.org/ontology/bibo/DocumentStatus <br/>
     * Label: published@en  <br/>
     * Comment: Published document@en  <br/>
     */
    public static final URI published = new URIImpl("http://purl.org/ontology/bibo/status/published");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Thing <br/>
     * Label: rejected@en  <br/>
     * Comment: Rejected for publication after peer reviewing.@en  <br/>
     */
    public static final URI rejected = new URIImpl("http://purl.org/ontology/bibo/status/rejected");
    /**
     * Type: Instance of http://purl.org/ontology/bibo/DocumentStatus <br/>
     * Label: unpublished@en  <br/>
     * Comment: Unpublished document@en  <br/>
     */
    public static final URI unpublished = new URIImpl("http://purl.org/ontology/bibo/status/unpublished");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Thing <br/>
     * Label: M.A.@en  <br/>
     * Comment: masters degree in arts@en  <br/>
     */
    public static final URI ma = new URIImpl("http://purl.org/ontology/bibo/degrees/ma");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Thing <br/>
     * Label: M.S.@en  <br/>
     * Comment: masters degree in science@en  <br/>
     */
    public static final URI ms = new URIImpl("http://purl.org/ontology/bibo/degrees/ms");
    /**
     * Type: Instance of http://purl.org/ontology/bibo/ThesisDegree <br/>
     * Label: PhD degree@en  <br/>
     * Comment: PhD degree@en  <br/>
     */
    public static final URI phd = new URIImpl("http://purl.org/ontology/bibo/degrees/phd");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: abstract  <br/>
     * Comment: A summary of the resource.  <br/>
     * Domain: http://www.w3.org/2000/01/rdf-schema#Resource  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI abstract_ = new URIImpl("http://purl.org/ontology/bibo/abstract");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: date argued@en  <br/>
     * Comment: The date on which a legal case is argued before a court. Date is of format xsd:date@en  <br/>
     * Domain: http://purl.org/ontology/bibo/LegalDocument  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI argued = new URIImpl("http://purl.org/ontology/bibo/argued");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx28  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI asin = new URIImpl("http://purl.org/ontology/bibo/asin");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: chapter@en  <br/>
     * Comment: An chapter number@en  <br/>
     * Domain: http://purl.org/ontology/bibo/BookSection  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI chapter = new URIImpl("http://purl.org/ontology/bibo/chapter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx31  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI coden = new URIImpl("http://purl.org/ontology/bibo/coden");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: content@en  <br/>
     * Comment: This property is for a plain-text rendering of the content of a Document. While the plain-text content of an entire document could be described by this property.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI content = new URIImpl("http://purl.org/ontology/bibo/content");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx34  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI doi = new URIImpl("http://purl.org/ontology/bibo/doi");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx37  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI eanucc13 = new URIImpl("http://purl.org/ontology/bibo/eanucc13");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: edition@en  <br/>
     * Comment: The name defining a special edition of a document. Normally its a literal value composed of a version number and words.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI edition = new URIImpl("http://purl.org/ontology/bibo/edition");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx40  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI eissn = new URIImpl("http://purl.org/ontology/bibo/eissn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx43  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI gtin14 = new URIImpl("http://purl.org/ontology/bibo/gtin14");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx46  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI handle = new URIImpl("http://purl.org/ontology/bibo/handle");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx49  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI identifier = new URIImpl("http://purl.org/ontology/bibo/identifier");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     */
    public static final URI isbn = new URIImpl("http://purl.org/ontology/bibo/isbn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx52  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI isbn10 = new URIImpl("http://purl.org/ontology/bibo/isbn10");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx55  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI isbn13 = new URIImpl("http://purl.org/ontology/bibo/isbn13");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx58  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI issn = new URIImpl("http://purl.org/ontology/bibo/issn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: issue@en  <br/>
     * Comment: An issue number@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Issue  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI issue = new URIImpl("http://purl.org/ontology/bibo/issue");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx61  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI lccn = new URIImpl("http://purl.org/ontology/bibo/lccn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: locator@en  <br/>
     * Comment: A description (often numeric) that locates an item within a containing document or collection.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI locator = new URIImpl("http://purl.org/ontology/bibo/locator");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: number of pages@en  <br/>
     * Comment: The number of pages contained in a document@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI numPages = new URIImpl("http://purl.org/ontology/bibo/numPages");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: number of volumes@en  <br/>
     * Comment: The number of volumes contained in a collection of documents (usually a series, periodical, etc.).@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Collection  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI numVolumes = new URIImpl("http://purl.org/ontology/bibo/numVolumes");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: number@en  <br/>
     * Comment: A generic item or document number. Not to be confused with issue number.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI number = new URIImpl("http://purl.org/ontology/bibo/number");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx64  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI oclcnum = new URIImpl("http://purl.org/ontology/bibo/oclcnum");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: page end@en  <br/>
     * Comment: Ending page number within a continuous page range.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI pageEnd = new URIImpl("http://purl.org/ontology/bibo/pageEnd");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: page start@en  <br/>
     * Comment: Starting page number within a continuous page range.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI pageStart = new URIImpl("http://purl.org/ontology/bibo/pageStart");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: pages@en  <br/>
     * Comment: A string of non-contiguous page spans that locate a Document within a Collection. Example: 23-25, 34, 54-56. For continuous page ranges, use the pageStart and pageEnd properties.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI pages = new URIImpl("http://purl.org/ontology/bibo/pages");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx67  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI pmid = new URIImpl("http://purl.org/ontology/bibo/pmid");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: prefix name@en  <br/>
     * Comment: The prefix of a name@en  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI prefixName = new URIImpl("http://purl.org/ontology/bibo/prefixName");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: section@en  <br/>
     * Comment: A section number@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI section = new URIImpl("http://purl.org/ontology/bibo/section");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI shortDescription = new URIImpl("http://purl.org/ontology/bibo/shortDescription");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: short title@en  <br/>
     * Comment: The abbreviation of a title.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI shortTitle = new URIImpl("http://purl.org/ontology/bibo/shortTitle");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx70  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI sici = new URIImpl("http://purl.org/ontology/bibo/sici");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: suffix name@en  <br/>
     * Comment: The suffix of a name@en  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI suffixName = new URIImpl("http://purl.org/ontology/bibo/suffixName");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: _:node15g74lmufx73  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI upc = new URIImpl("http://purl.org/ontology/bibo/upc");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: uri@en  <br/>
     * Comment: Universal Resource Identifier of a document@en  <br/>
     * Domain: _:node15g74lmufx76  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI uri = new URIImpl("http://purl.org/ontology/bibo/uri");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: volume@en  <br/>
     * Comment: A volume number@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI volume = new URIImpl("http://purl.org/ontology/bibo/volume");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: A legal decision that affirms a ruling.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/LegalDecision  <br/>
     * Range: http://purl.org/ontology/bibo/LegalDecision  <br/>
     */
    public static final URI affirmedBy = new URIImpl("http://purl.org/ontology/bibo/affirmedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: annotates@en  <br/>
     * Comment: Critical or explanatory note for a Document.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Note  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Resource  <br/>
     */
    public static final URI annotates = new URIImpl("http://purl.org/ontology/bibo/annotates");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: list of authors@en  <br/>
     * Comment: An ordered list of authors. Normally, this list is seen as a priority list that order authors by importance.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: _:node15g74lmufx1  <br/>
     */
    public static final URI authorList = new URIImpl("http://purl.org/ontology/bibo/authorList");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: cited by@en  <br/>
     * Comment: Relates a document to another document that cites the
first document.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://purl.org/ontology/bibo/Document  <br/>
     */
    public static final URI citedBy = new URIImpl("http://purl.org/ontology/bibo/citedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: cites@en  <br/>
     * Comment: Relates a document to another document that is cited
by the first document as reference, comment, review, quotation or for
another purpose.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://purl.org/ontology/bibo/Document  <br/>
     */
    public static final URI cites = new URIImpl("http://purl.org/ontology/bibo/cites");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: list of contributors@en  <br/>
     * Comment: An ordered list of contributors. Normally, this list is seen as a priority list that order contributors by importance.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: _:node15g74lmufx4  <br/>
     */
    public static final URI contributorList = new URIImpl("http://purl.org/ontology/bibo/contributorList");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: court@en  <br/>
     * Comment: A court associated with a legal document; for example, that which issues a decision.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/LegalDocument  <br/>
     * Range: http://xmlns.com/foaf/0.1/Organization  <br/>
     */
    public static final URI court = new URIImpl("http://purl.org/ontology/bibo/court");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: status@en  <br/>
     * Comment: The thesis degree.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Thesis  <br/>
     * Range: http://purl.org/ontology/bibo/ThesisDegree  <br/>
     */
    public static final URI degree = new URIImpl("http://purl.org/ontology/bibo/degree");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: director  <br/>
     * Comment: A Film director.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/AudioVisualDocument  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI director = new URIImpl("http://purl.org/ontology/bibo/director");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: distributor@en  <br/>
     * Comment: Distributor of a document or a collection of documents.@en  <br/>
     * Domain: _:node15g74lmufx7  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI distributor = new URIImpl("http://purl.org/ontology/bibo/distributor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: editor  <br/>
     * Comment: A person having managerial and sometimes policy-making responsibility for the editorial part of a publishing firm or of a newspaper, magazine, or other publication.@en  <br/>
     * Domain: _:node15g74lmufx10  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI editor = new URIImpl("http://purl.org/ontology/bibo/editor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: list of editors@en  <br/>
     * Comment: An ordered list of editors. Normally, this list is seen as a priority list that order editors by importance.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: _:node15g74lmufx13  <br/>
     */
    public static final URI editorList = new URIImpl("http://purl.org/ontology/bibo/editorList");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: interviewee  <br/>
     * Comment: An agent that is interviewed by another agent.@en  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI interviewee = new URIImpl("http://purl.org/ontology/bibo/interviewee");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: interviewer  <br/>
     * Comment: An agent that interview another agent.@en  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI interviewer = new URIImpl("http://purl.org/ontology/bibo/interviewer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: issuer  <br/>
     * Comment: An entity responsible for issuing often informally published documents such as press releases, reports, etc.  <br/>
     * Domain: _:node15g74lmufx16  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI issuer = new URIImpl("http://purl.org/ontology/bibo/issuer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: organizer@en  <br/>
     * Comment: The organizer of an event; includes conference organizers, but also government agencies or other bodies that are responsible for conducting hearings.@en  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI organizer = new URIImpl("http://purl.org/ontology/bibo/organizer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: owner@en  <br/>
     * Comment: Owner of a document or a collection of documents.@en  <br/>
     * Domain: _:node15g74lmufx19  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI owner = new URIImpl("http://purl.org/ontology/bibo/owner");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: performer  <br/>
     * Domain: http://purl.org/ontology/bibo/Performance  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI performer = new URIImpl("http://purl.org/ontology/bibo/performer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: presented at@en  <br/>
     * Comment: Relates a document to an event; for example, a paper to a conference.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://purl.org/ontology/bibo/Event  <br/>
     */
    public static final URI presentedAt = new URIImpl("http://purl.org/ontology/bibo/presentedAt");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: presented at@en  <br/>
     * Comment: Relates an event to associated documents; for example, conference to a paper.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Event  <br/>
     * Range: http://purl.org/ontology/bibo/Document  <br/>
     */
    public static final URI presents = new URIImpl("http://purl.org/ontology/bibo/presents");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: producer@en  <br/>
     * Comment: Producer of a document or a collection of documents.@en  <br/>
     * Domain: _:node15g74lmufx22  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI producer = new URIImpl("http://purl.org/ontology/bibo/producer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: recipient  <br/>
     * Comment: An agent that receives a communication document.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/PersonalCommunicationDocument  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI recipient = new URIImpl("http://purl.org/ontology/bibo/recipient");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: The resource in which another resource is reproduced.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://purl.org/ontology/bibo/Document  <br/>
     */
    public static final URI reproducedIn = new URIImpl("http://purl.org/ontology/bibo/reproducedIn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: A legal decision that reverses a ruling.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/LegalDecision  <br/>
     * Range: http://purl.org/ontology/bibo/LegalDecision  <br/>
     */
    public static final URI reversedBy = new URIImpl("http://purl.org/ontology/bibo/reversedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: review of@en  <br/>
     * Comment: Relates a review document to a reviewed thing (resource, item, etc.).@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Resource  <br/>
     */
    public static final URI reviewOf = new URIImpl("http://purl.org/ontology/bibo/reviewOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: status@en  <br/>
     * Comment: The publication status of (typically academic) content.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://purl.org/ontology/bibo/DocumentStatus  <br/>
     */
    public static final URI status = new URIImpl("http://purl.org/ontology/bibo/status");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: A legal decision on appeal that takes action on a case (affirming it, reversing it, etc.).@en  <br/>
     * Domain: http://purl.org/ontology/bibo/LegalDecision  <br/>
     * Range: http://purl.org/ontology/bibo/LegalDecision  <br/>
     */
    public static final URI subsequentLegalDecision = new URIImpl("http://purl.org/ontology/bibo/subsequentLegalDecision");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: transcript of@en  <br/>
     * Comment: Relates a document to some transcribed original.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Resource  <br/>
     */
    public static final URI transcriptOf = new URIImpl("http://purl.org/ontology/bibo/transcriptOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: translation of@en  <br/>
     * Comment: Relates a translated document to the original document.@en  <br/>
     * Domain: http://purl.org/ontology/bibo/Document  <br/>
     * Range: http://purl.org/ontology/bibo/Document  <br/>
     */
    public static final URI translationOf = new URIImpl("http://purl.org/ontology/bibo/translationOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: translator  <br/>
     * Comment: A person who translates written document from one language to another.@en  <br/>
     * Domain: _:node15g74lmufx25  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI translator = new URIImpl("http://purl.org/ontology/bibo/translator");
}
