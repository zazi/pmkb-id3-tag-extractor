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
 * input file: /src/main/resources/smiy/pmkb/vocabulary/foaf.owl
 * namespace: http://xmlns.com/foaf/0.1/
 */
public class FOAF {

    /** Path to the ontology resource */
    public static final String FOAF_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/foaf.owl";

    /**
     * Puts the FOAF ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getFOAFOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(FOAF_RESOURCE_PATH, FOAF.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + FOAF_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for FOAF */
    public static final URI NS_FOAF = new URIImpl("http://xmlns.com/foaf/0.1/");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Label Property  <br/>
     * Comment: A foaf:LabelProperty is any RDF property with texual values that serve as labels.  <br/>
     */
    public static final URI LabelProperty = new URIImpl("http://xmlns.com/foaf/0.1/LabelProperty");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Person  <br/>
     * Comment: A person.  <br/>
     */
    public static final URI Person = new URIImpl("http://xmlns.com/foaf/0.1/Person");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Document  <br/>
     * Comment: A document.  <br/>
     */
    public static final URI Document = new URIImpl("http://xmlns.com/foaf/0.1/Document");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Organization  <br/>
     * Comment: An organization.  <br/>
     */
    public static final URI Organization = new URIImpl("http://xmlns.com/foaf/0.1/Organization");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Group  <br/>
     * Comment: A class of Agents.  <br/>
     */
    public static final URI Group = new URIImpl("http://xmlns.com/foaf/0.1/Group");
    /**
     * Type: Class <br/>
     * Label: Agent  <br/>
     * Comment: An agent (eg. person, group, software or physical artifact).  <br/>
     */
    public static final URI Agent = new URIImpl("http://xmlns.com/foaf/0.1/Agent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Project  <br/>
     * Comment: A project (a collective endeavour of some kind).  <br/>
     */
    public static final URI Project = new URIImpl("http://xmlns.com/foaf/0.1/Project");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Image  <br/>
     * Comment: An image.  <br/>
     */
    public static final URI Image = new URIImpl("http://xmlns.com/foaf/0.1/Image");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: PersonalProfileDocument  <br/>
     * Comment: A personal profile RDF document.  <br/>
     */
    public static final URI PersonalProfileDocument = new URIImpl("http://xmlns.com/foaf/0.1/PersonalProfileDocument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Online Account  <br/>
     * Comment: An online account.  <br/>
     */
    public static final URI OnlineAccount = new URIImpl("http://xmlns.com/foaf/0.1/OnlineAccount");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Online Gaming Account  <br/>
     * Comment: An online gaming account.  <br/>
     */
    public static final URI OnlineGamingAccount = new URIImpl("http://xmlns.com/foaf/0.1/OnlineGamingAccount");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Online E-commerce Account  <br/>
     * Comment: An online e-commerce account.  <br/>
     */
    public static final URI OnlineEcommerceAccount = new URIImpl("http://xmlns.com/foaf/0.1/OnlineEcommerceAccount");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Online Chat Account  <br/>
     * Comment: An online chat account.  <br/>
     */
    public static final URI OnlineChatAccount = new URIImpl("http://xmlns.com/foaf/0.1/OnlineChatAccount");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: personal mailbox  <br/>
     * Comment: A  personal mailbox, ie. an Internet mailbox associated with exactly one owner, the first owner of this mailbox. This is a 'static inverse functional property', in that  there is (across time and change) at most one individual that ever has any particular value for foaf:mbox.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI mbox = new URIImpl("http://xmlns.com/foaf/0.1/mbox");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: sha1sum of a personal mailbox URI name  <br/>
     * Comment: The sha1sum of the URI of an Internet mailbox associated with exactly one owner, the  first owner of the mailbox.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI mbox_sha1sum = new URIImpl("http://xmlns.com/foaf/0.1/mbox_sha1sum");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: gender  <br/>
     * Comment: The gender of this Agent (typically but not necessarily 'male' or 'female').  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI gender = new URIImpl("http://xmlns.com/foaf/0.1/gender");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: geekcode  <br/>
     * Comment: A textual geekcode for this person, see http://www.geekcode.com/geek.html  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI geekcode = new URIImpl("http://xmlns.com/foaf/0.1/geekcode");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: DNA checksum  <br/>
     * Comment: A checksum for the DNA of some thing. Joke.  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI dnaChecksum = new URIImpl("http://xmlns.com/foaf/0.1/dnaChecksum");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: sha1sum (hex)  <br/>
     * Comment: A sha1sum hash, in hex.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI sha1 = new URIImpl("http://xmlns.com/foaf/0.1/sha1");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: based near  <br/>
     * Comment: A location that something is based near, for some broadly human notion of near.  <br/>
     * Domain: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     * Range: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     */
    public static final URI based_near = new URIImpl("http://xmlns.com/foaf/0.1/based_near");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: title  <br/>
     * Comment: Title (Mr, Mrs, Ms, Dr. etc)  <br/>
     */
    public static final URI title = new URIImpl("http://xmlns.com/foaf/0.1/title");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: nickname  <br/>
     * Comment: A short informal nickname characterising an agent (includes login identifiers, IRC and other chat nicknames).  <br/>
     */
    public static final URI nick = new URIImpl("http://xmlns.com/foaf/0.1/nick");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: jabber ID  <br/>
     * Comment: A jabber ID for something.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI jabberID = new URIImpl("http://xmlns.com/foaf/0.1/jabberID");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: AIM chat ID  <br/>
     * Comment: An AIM chat ID  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI aimChatID = new URIImpl("http://xmlns.com/foaf/0.1/aimChatID");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: Skype ID  <br/>
     * Comment: A Skype ID  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI skypeID = new URIImpl("http://xmlns.com/foaf/0.1/skypeID");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: ICQ chat ID  <br/>
     * Comment: An ICQ chat ID  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI icqChatID = new URIImpl("http://xmlns.com/foaf/0.1/icqChatID");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: Yahoo chat ID  <br/>
     * Comment: A Yahoo chat ID  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI yahooChatID = new URIImpl("http://xmlns.com/foaf/0.1/yahooChatID");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: MSN chat ID  <br/>
     * Comment: An MSN chat ID  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI msnChatID = new URIImpl("http://xmlns.com/foaf/0.1/msnChatID");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: name  <br/>
     * Comment: A name for some thing.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI name = new URIImpl("http://xmlns.com/foaf/0.1/name");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: firstName  <br/>
     * Comment: The first name of a person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI firstName = new URIImpl("http://xmlns.com/foaf/0.1/firstName");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: lastName  <br/>
     * Comment: The last name of a person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI lastName = new URIImpl("http://xmlns.com/foaf/0.1/lastName");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: Given name  <br/>
     * Comment: The given name of some person.  <br/>
     */
    public static final URI givenName = new URIImpl("http://xmlns.com/foaf/0.1/givenName");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: Given name  <br/>
     * Comment: The given name of some person.  <br/>
     */
    public static final URI givenname = new URIImpl("http://xmlns.com/foaf/0.1/givenname");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: Surname  <br/>
     * Comment: The surname of some person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI surname = new URIImpl("http://xmlns.com/foaf/0.1/surname");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: family_name  <br/>
     * Comment: The family name of some person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI family_name = new URIImpl("http://xmlns.com/foaf/0.1/family_name");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: familyName  <br/>
     * Comment: The family name of some person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI familyName = new URIImpl("http://xmlns.com/foaf/0.1/familyName");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: phone  <br/>
     * Comment: A phone,  specified using fully qualified tel: URI scheme (refs: http://www.w3.org/Addressing/schemes.html#tel).  <br/>
     */
    public static final URI phone = new URIImpl("http://xmlns.com/foaf/0.1/phone");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: homepage  <br/>
     * Comment: A homepage for some thing.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI homepage = new URIImpl("http://xmlns.com/foaf/0.1/homepage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: weblog  <br/>
     * Comment: A weblog of some thing (whether person, group, company etc.).  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI weblog = new URIImpl("http://xmlns.com/foaf/0.1/weblog");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: openid  <br/>
     * Comment: An OpenID for an Agent.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI openid = new URIImpl("http://xmlns.com/foaf/0.1/openid");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: tipjar  <br/>
     * Comment: A tipjar document for this agent, describing means for payment and reward.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI tipjar = new URIImpl("http://xmlns.com/foaf/0.1/tipjar");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: plan  <br/>
     * Comment: A .plan comment, in the tradition of finger and '.plan' files.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI plan = new URIImpl("http://xmlns.com/foaf/0.1/plan");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: made  <br/>
     * Comment: Something that was made by this agent.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI made = new URIImpl("http://xmlns.com/foaf/0.1/made");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: maker  <br/>
     * Comment: An agent that  made this thing.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI maker = new URIImpl("http://xmlns.com/foaf/0.1/maker");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: image  <br/>
     * Comment: An image that can be used to represent some thing (ie. those depictions which are particularly representative of something, eg. one's photo on a homepage).  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://xmlns.com/foaf/0.1/Image  <br/>
     */
    public static final URI img = new URIImpl("http://xmlns.com/foaf/0.1/img");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: depiction  <br/>
     * Comment: A depiction of some thing.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://xmlns.com/foaf/0.1/Image  <br/>
     */
    public static final URI depiction = new URIImpl("http://xmlns.com/foaf/0.1/depiction");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: depicts  <br/>
     * Comment: A thing depicted in this representation.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Image  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI depicts = new URIImpl("http://xmlns.com/foaf/0.1/depicts");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: thumbnail  <br/>
     * Comment: A derived thumbnail image.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Image  <br/>
     * Range: http://xmlns.com/foaf/0.1/Image  <br/>
     */
    public static final URI thumbnail = new URIImpl("http://xmlns.com/foaf/0.1/thumbnail");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: myersBriggs  <br/>
     * Comment: A Myers Briggs (MBTI) personality classification.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI myersBriggs = new URIImpl("http://xmlns.com/foaf/0.1/myersBriggs");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: workplace homepage  <br/>
     * Comment: A workplace homepage of some person; the homepage of an organization they work for.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI workplaceHomepage = new URIImpl("http://xmlns.com/foaf/0.1/workplaceHomepage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: work info homepage  <br/>
     * Comment: A work info homepage of some person; a page about their work for some organization.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI workInfoHomepage = new URIImpl("http://xmlns.com/foaf/0.1/workInfoHomepage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: schoolHomepage  <br/>
     * Comment: A homepage of a school attended by the person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI schoolHomepage = new URIImpl("http://xmlns.com/foaf/0.1/schoolHomepage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: knows  <br/>
     * Comment: A person known by this person (indicating some level of reciprocated interaction between the parties).  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://xmlns.com/foaf/0.1/Person  <br/>
     */
    public static final URI knows = new URIImpl("http://xmlns.com/foaf/0.1/knows");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: interest  <br/>
     * Comment: A page about a topic of interest to this person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI interest = new URIImpl("http://xmlns.com/foaf/0.1/interest");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: topic_interest  <br/>
     * Comment: A thing of interest to this person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI topic_interest = new URIImpl("http://xmlns.com/foaf/0.1/topic_interest");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: publications  <br/>
     * Comment: A link to the publications of this person.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI publications = new URIImpl("http://xmlns.com/foaf/0.1/publications");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: current project  <br/>
     * Comment: A current project this person works on.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI currentProject = new URIImpl("http://xmlns.com/foaf/0.1/currentProject");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: past project  <br/>
     * Comment: A project this person has previously worked on.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Person  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI pastProject = new URIImpl("http://xmlns.com/foaf/0.1/pastProject");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: funded by  <br/>
     * Comment: An organization funding a project or person.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI fundedBy = new URIImpl("http://xmlns.com/foaf/0.1/fundedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: logo  <br/>
     * Comment: A logo representing some thing.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI logo = new URIImpl("http://xmlns.com/foaf/0.1/logo");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: topic  <br/>
     * Comment: A topic of some page or document.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Document  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI topic = new URIImpl("http://xmlns.com/foaf/0.1/topic");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: primary topic  <br/>
     * Comment: The primary topic of some page or document.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Document  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI primaryTopic = new URIImpl("http://xmlns.com/foaf/0.1/primaryTopic");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: focus  <br/>
     * Comment: The underlying or 'focal' entity associated with some SKOS-described concept.  <br/>
     * Domain: http://www.w3.org/2004/02/skos/core#Concept  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI focus = new URIImpl("http://xmlns.com/foaf/0.1/focus");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: is primary topic of  <br/>
     * Comment: A document that this thing is the primary topic of.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI isPrimaryTopicOf = new URIImpl("http://xmlns.com/foaf/0.1/isPrimaryTopicOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: page  <br/>
     * Comment: A page or document about this thing.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI page = new URIImpl("http://xmlns.com/foaf/0.1/page");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: theme  <br/>
     * Comment: A theme.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI theme = new URIImpl("http://xmlns.com/foaf/0.1/theme");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: account  <br/>
     * Comment: Indicates an account held by this agent.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/OnlineAccount  <br/>
     */
    public static final URI account = new URIImpl("http://xmlns.com/foaf/0.1/account");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: account  <br/>
     * Comment: Indicates an account held by this agent.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/OnlineAccount  <br/>
     */
    public static final URI holdsAccount = new URIImpl("http://xmlns.com/foaf/0.1/holdsAccount");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: account service homepage  <br/>
     * Comment: Indicates a homepage of the service provide for this online account.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/OnlineAccount  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI accountServiceHomepage = new URIImpl("http://xmlns.com/foaf/0.1/accountServiceHomepage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: account name  <br/>
     * Comment: Indicates the name (identifier) associated with this online account.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/OnlineAccount  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI accountName = new URIImpl("http://xmlns.com/foaf/0.1/accountName");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: member  <br/>
     * Comment: Indicates a member of a Group  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Group  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI member = new URIImpl("http://xmlns.com/foaf/0.1/member");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#AnnotationProperty <br/>
     * Label: membershipClass  <br/>
     * Comment: Indicates the class of individuals that are a member of a Group  <br/>
     */
    public static final URI membershipClass = new URIImpl("http://xmlns.com/foaf/0.1/membershipClass");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: birthday  <br/>
     * Comment: The birthday of this Agent, represented in mm-dd string form, eg. '12-31'.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI birthday = new URIImpl("http://xmlns.com/foaf/0.1/birthday");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: age  <br/>
     * Comment: The age in years of some agent.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI age = new URIImpl("http://xmlns.com/foaf/0.1/age");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: status  <br/>
     * Comment: A string expressing what the user is happy for the general public (normally) to know about their current activity.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI status = new URIImpl("http://xmlns.com/foaf/0.1/status");
}
