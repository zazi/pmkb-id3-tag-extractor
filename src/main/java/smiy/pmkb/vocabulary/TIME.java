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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Mon Oct 25 15:13:02 CEST 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/time.owl
 * namespace: http://www.w3.org/2006/time
 */
public class TIME {

    /** Path to the ontology resource */
    public static final String TIME_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/time.owl";

    /**
     * Puts the TIME ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getTIMEOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(TIME_RESOURCE_PATH, TIME.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + TIME_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for TIME */
    public static final URI NS_TIME = new URIImpl("http://www.w3.org/2006/time");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI Instant = new URIImpl("http://www.w3.org/2006/time#Instant");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI Interval = new URIImpl("http://www.w3.org/2006/time#Interval");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI TemporalEntity = new URIImpl("http://www.w3.org/2006/time#TemporalEntity");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI ProperInterval = new URIImpl("http://www.w3.org/2006/time#ProperInterval");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI DurationDescription = new URIImpl("http://www.w3.org/2006/time#DurationDescription");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI Year = new URIImpl("http://www.w3.org/2006/time#Year");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI DateTimeInterval = new URIImpl("http://www.w3.org/2006/time#DateTimeInterval");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI TemporalUnit = new URIImpl("http://www.w3.org/2006/time#TemporalUnit");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI DateTimeDescription = new URIImpl("http://www.w3.org/2006/time#DateTimeDescription");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI DayOfWeek = new URIImpl("http://www.w3.org/2006/time#DayOfWeek");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI TimeZone = new URIImpl("http://www.w3.org/2006/timezone#TimeZone");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI January = new URIImpl("http://www.w3.org/2006/time#January");
    /**
     * Type: Instance of http://www.w3.org/2006/time#TemporalUnit <br/>
     */
    public static final URI unitSecond = new URIImpl("http://www.w3.org/2006/time#unitSecond");
    /**
     * Type: Instance of http://www.w3.org/2006/time#TemporalUnit <br/>
     */
    public static final URI unitMinute = new URIImpl("http://www.w3.org/2006/time#unitMinute");
    /**
     * Type: Instance of http://www.w3.org/2006/time#TemporalUnit <br/>
     */
    public static final URI unitHour = new URIImpl("http://www.w3.org/2006/time#unitHour");
    /**
     * Type: Instance of http://www.w3.org/2006/time#TemporalUnit <br/>
     */
    public static final URI unitDay = new URIImpl("http://www.w3.org/2006/time#unitDay");
    /**
     * Type: Instance of http://www.w3.org/2006/time#TemporalUnit <br/>
     */
    public static final URI unitWeek = new URIImpl("http://www.w3.org/2006/time#unitWeek");
    /**
     * Type: Instance of http://www.w3.org/2006/time#TemporalUnit <br/>
     */
    public static final URI unitMonth = new URIImpl("http://www.w3.org/2006/time#unitMonth");
    /**
     * Type: Instance of http://www.w3.org/2006/time#TemporalUnit <br/>
     */
    public static final URI unitYear = new URIImpl("http://www.w3.org/2006/time#unitYear");
    /**
     * Type: Instance of http://www.w3.org/2006/time#DayOfWeek <br/>
     */
    public static final URI Sunday = new URIImpl("http://www.w3.org/2006/time#Sunday");
    /**
     * Type: Instance of http://www.w3.org/2006/time#DayOfWeek <br/>
     */
    public static final URI Monday = new URIImpl("http://www.w3.org/2006/time#Monday");
    /**
     * Type: Instance of http://www.w3.org/2006/time#DayOfWeek <br/>
     */
    public static final URI Tuesday = new URIImpl("http://www.w3.org/2006/time#Tuesday");
    /**
     * Type: Instance of http://www.w3.org/2006/time#DayOfWeek <br/>
     */
    public static final URI Wednesday = new URIImpl("http://www.w3.org/2006/time#Wednesday");
    /**
     * Type: Instance of http://www.w3.org/2006/time#DayOfWeek <br/>
     */
    public static final URI Thursday = new URIImpl("http://www.w3.org/2006/time#Thursday");
    /**
     * Type: Instance of http://www.w3.org/2006/time#DayOfWeek <br/>
     */
    public static final URI Friday = new URIImpl("http://www.w3.org/2006/time#Friday");
    /**
     * Type: Instance of http://www.w3.org/2006/time#DayOfWeek <br/>
     */
    public static final URI Saturday = new URIImpl("http://www.w3.org/2006/time#Saturday");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DurationDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#decimal  <br/>
     */
    public static final URI years = new URIImpl("http://www.w3.org/2006/time#years");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DurationDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#decimal  <br/>
     */
    public static final URI months = new URIImpl("http://www.w3.org/2006/time#months");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DurationDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#decimal  <br/>
     */
    public static final URI weeks = new URIImpl("http://www.w3.org/2006/time#weeks");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DurationDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#decimal  <br/>
     */
    public static final URI days = new URIImpl("http://www.w3.org/2006/time#days");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DurationDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#decimal  <br/>
     */
    public static final URI hours = new URIImpl("http://www.w3.org/2006/time#hours");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DurationDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#decimal  <br/>
     */
    public static final URI minutes = new URIImpl("http://www.w3.org/2006/time#minutes");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DurationDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#decimal  <br/>
     */
    public static final URI seconds = new URIImpl("http://www.w3.org/2006/time#seconds");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#gYear  <br/>
     */
    public static final URI year = new URIImpl("http://www.w3.org/2006/time#year");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#gMonth  <br/>
     */
    public static final URI month = new URIImpl("http://www.w3.org/2006/time#month");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#nonNegativeInteger  <br/>
     */
    public static final URI week = new URIImpl("http://www.w3.org/2006/time#week");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#gDay  <br/>
     */
    public static final URI day = new URIImpl("http://www.w3.org/2006/time#day");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#nonNegativeInteger  <br/>
     */
    public static final URI dayOfYear = new URIImpl("http://www.w3.org/2006/time#dayOfYear");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#nonNegativeInteger  <br/>
     */
    public static final URI hour = new URIImpl("http://www.w3.org/2006/time#hour");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#nonNegativeInteger  <br/>
     */
    public static final URI minute = new URIImpl("http://www.w3.org/2006/time#minute");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#decimal  <br/>
     */
    public static final URI second = new URIImpl("http://www.w3.org/2006/time#second");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#Instant  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#dateTime  <br/>
     */
    public static final URI inXSDDateTime = new URIImpl("http://www.w3.org/2006/time#inXSDDateTime");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeInterval  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#dateTime  <br/>
     */
    public static final URI xsdDateTime = new URIImpl("http://www.w3.org/2006/time#xsdDateTime");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#TransitiveProperty <br/>
     * Domain: http://www.w3.org/2006/time#TemporalEntity  <br/>
     * Range: http://www.w3.org/2006/time#TemporalEntity  <br/>
     */
    public static final URI before = new URIImpl("http://www.w3.org/2006/time#before");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI after = new URIImpl("http://www.w3.org/2006/time#after");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#TemporalEntity  <br/>
     * Range: http://www.w3.org/2006/time#Instant  <br/>
     */
    public static final URI hasBeginning = new URIImpl("http://www.w3.org/2006/time#hasBeginning");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#TemporalEntity  <br/>
     * Range: http://www.w3.org/2006/time#Instant  <br/>
     */
    public static final URI hasEnd = new URIImpl("http://www.w3.org/2006/time#hasEnd");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#Interval  <br/>
     * Range: http://www.w3.org/2006/time#Instant  <br/>
     */
    public static final URI inside = new URIImpl("http://www.w3.org/2006/time#inside");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#ProperInterval  <br/>
     * Range: http://www.w3.org/2006/time#ProperInterval  <br/>
     */
    public static final URI intervalEquals = new URIImpl("http://www.w3.org/2006/time#intervalEquals");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#ProperInterval  <br/>
     * Range: http://www.w3.org/2006/time#ProperInterval  <br/>
     */
    public static final URI intervalBefore = new URIImpl("http://www.w3.org/2006/time#intervalBefore");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#ProperInterval  <br/>
     * Range: http://www.w3.org/2006/time#ProperInterval  <br/>
     */
    public static final URI intervalMeets = new URIImpl("http://www.w3.org/2006/time#intervalMeets");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#ProperInterval  <br/>
     * Range: http://www.w3.org/2006/time#ProperInterval  <br/>
     */
    public static final URI intervalOverlaps = new URIImpl("http://www.w3.org/2006/time#intervalOverlaps");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#ProperInterval  <br/>
     * Range: http://www.w3.org/2006/time#ProperInterval  <br/>
     */
    public static final URI intervalStarts = new URIImpl("http://www.w3.org/2006/time#intervalStarts");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#ProperInterval  <br/>
     * Range: http://www.w3.org/2006/time#ProperInterval  <br/>
     */
    public static final URI intervalDuring = new URIImpl("http://www.w3.org/2006/time#intervalDuring");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#ProperInterval  <br/>
     * Range: http://www.w3.org/2006/time#ProperInterval  <br/>
     */
    public static final URI intervalFinishes = new URIImpl("http://www.w3.org/2006/time#intervalFinishes");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI intervalAfter = new URIImpl("http://www.w3.org/2006/time#intervalAfter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI intervalMetBy = new URIImpl("http://www.w3.org/2006/time#intervalMetBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI intervalOverlappedBy = new URIImpl("http://www.w3.org/2006/time#intervalOverlappedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI intervalStartedBy = new URIImpl("http://www.w3.org/2006/time#intervalStartedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI intervalContains = new URIImpl("http://www.w3.org/2006/time#intervalContains");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI intervalFinishedBy = new URIImpl("http://www.w3.org/2006/time#intervalFinishedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#TemporalEntity  <br/>
     * Range: http://www.w3.org/2006/time#DurationDescription  <br/>
     */
    public static final URI hasDurationDescription = new URIImpl("http://www.w3.org/2006/time#hasDurationDescription");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2006/time#TemporalUnit  <br/>
     */
    public static final URI unitType = new URIImpl("http://www.w3.org/2006/time#unitType");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2006/time#DayOfWeek  <br/>
     */
    public static final URI dayOfWeek = new URIImpl("http://www.w3.org/2006/time#dayOfWeek");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     * Range: http://www.w3.org/2006/timezone#TimeZone  <br/>
     */
    public static final URI timeZone = new URIImpl("http://www.w3.org/2006/time#timeZone");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#Instant  <br/>
     * Range: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     */
    public static final URI inDateTime = new URIImpl("http://www.w3.org/2006/time#inDateTime");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://www.w3.org/2006/time#DateTimeInterval  <br/>
     * Range: http://www.w3.org/2006/time#DateTimeDescription  <br/>
     */
    public static final URI hasDateTimeDescription = new URIImpl("http://www.w3.org/2006/time#hasDateTimeDescription");
}
