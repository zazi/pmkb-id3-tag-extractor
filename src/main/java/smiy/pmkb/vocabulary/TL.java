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
 * input file: /src/main/resources/smiy/pmkb/vocabulary/timeline.owl
 * namespace: http://purl.org/NET/c4dm/timeline.owl#
 */
public class TL {

    /** Path to the ontology resource */
    public static final String TL_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/timeline.owl";

    /**
     * Puts the TL ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getTLOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(TL_RESOURCE_PATH, TL.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + TL_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for TL */
    public static final URI NS_TL = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: timeline  <br/>
     * Comment: Represents a linear and coherent piece of time -- can be either abstract (such as the one behind a score) or concrete (such as the universal time line).
Two timelines can be mapped using timeline maps.  <br/>
     */
    public static final URI TimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#TimeLine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: instant  <br/>
     * Comment: An instant (same as in OWL-Time)  <br/>
     */
    public static final URI Instant = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#Instant");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: interval  <br/>
     * Comment: An interval (same as in OWL-Time). Allen's relationships are defined in OWL-Time.  <br/>
     */
    public static final URI Interval = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#Interval");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: abstract interval  <br/>
     * Comment: An interval defined on an abstract time-line.  <br/>
     */
    public static final URI AbstractInterval = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#AbstractInterval");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: abstract timeline  <br/>
     * Comment: Abstract time lines may be used as a backbone for Score, Works, ... 
	This allows for TimeLine maps to relate works to a given 
	performance (this part was played at this time).  <br/>
     */
    public static final URI AbstractTimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#AbstractTimeLine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: instant on the universal timeline  <br/>
     * Comment: This concept expresses that an instant defined on the universal timeline must be associated to a dateTime value  <br/>
     */
    public static final URI UTInstant = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#UTInstant");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: uniform sampling map  <br/>
     * Comment: Describe the relation between a continuous time-line and its sampled equivalent  <br/>
     */
    public static final URI UniformSamplingMap = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#UniformSamplingMap");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: discrete time line  <br/>
     * Comment: A discrete time line (like the time line backing a digital signal  <br/>
     */
    public static final URI DiscreteTimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#DiscreteTimeLine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: relative timeline  <br/>
     * Comment: Semi infinite time line...canonical coordinate system --> adressed through xsd:duration since the instant 0.  <br/>
     */
    public static final URI RelativeTimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#RelativeTimeLine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: timeline map  <br/>
     * Comment: Allows to map two time lines together  <br/>
     */
    public static final URI TimeLineMap = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#TimeLineMap");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: uniform windowing map  <br/>
     * Comment: Describes the relation between a discrete time line and its windowed equivalent  <br/>
     */
    public static final URI UniformWindowingMap = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#UniformWindowingMap");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Uniform sampling and windowing map  <br/>
     * Comment: Describes the relation between a continuous time-line, and a time-line that corresponds to its sampled and windowed equivalent  <br/>
     */
    public static final URI UniformSamplingWindowingMap = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#UniformSamplingWindowingMap");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: discrete instant  <br/>
     * Comment: An instant defined on a discrete timeline  <br/>
     */
    public static final URI DiscreteInstant = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#DiscreteInstant");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: continuous timeline  <br/>
     * Comment: A continuous timeline, like the universal one, or the one backing an analog signal  <br/>
     */
    public static final URI ContinuousTimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#ContinuousTimeLine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: physical timeline  <br/>
     * Comment: A "physical" time-line (the universal time line (UTC)) is an instance of this class. Other time zones consists in instances of this class as well, with a "shifting" time line map relating them to the universal time line map.  <br/>
     */
    public static final URI PhysicalTimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#PhysicalTimeLine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: origin map  <br/>
     * Comment: A timeline map linking a physical timeline to a relative one (originating at some point on the physical timeline)  <br/>
     */
    public static final URI OriginMap = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#OriginMap");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: discrete interval  <br/>
     * Comment: An interval defined on a discrete timeline, like the one backing a digital signal  <br/>
     */
    public static final URI DiscreteInterval = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#DiscreteInterval");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: relative interval  <br/>
     * Comment: an interval defined on a relative timeline  <br/>
     */
    public static final URI RelativeInterval = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#RelativeInterval");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: shift map  <br/>
     * Comment: a map just shifting one timeline to another  <br/>
     */
    public static final URI ShiftMap = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#ShiftMap");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: universal timeline interval  <br/>
     * Comment: an interval defined on the universal time line  <br/>
     */
    public static final URI UTInterval = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#UTInterval");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: relative instant  <br/>
     * Comment: An instant defined on a relative timeline  <br/>
     */
    public static final URI RelativeInstant = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#RelativeInstant");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: abstract instant  <br/>
     * Comment: An instant defined on an abstract timeline  <br/>
     */
    public static final URI AbstractInstant = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#AbstractInstant");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/timeline.owl#PhysicalTimeLine <br/>
     * Comment: this is the `universal' time line -- can adress time intervals on it using date/dateTime -- UTC  <br/>
     */
    public static final URI universaltimeline = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#universaltimeline");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: at  <br/>
     * Comment: refers to a point or an interval on the time line, through an explicit datatype  <br/>
     * Domain: _:node15fhoafpax4  <br/>
     */
    public static final URI at = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#at");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: duration  <br/>
     * Comment: the duration of a time interval  <br/>
     * Domain: http://purl.org/NET/c4dm/timeline.owl#Interval  <br/>
     */
    public static final URI duration = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#duration");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: ends at  <br/>
     * Comment: refers to the end of a time interval, through an explicit datatype. time:hasEnd can be used as well, if you want to associate the end of the interval to an explicit time point resource  <br/>
     * Domain: http://purl.org/NET/c4dm/timeline.owl#Interval  <br/>
     */
    public static final URI end = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#end");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     */
    public static final URI endsAt = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#endsAt");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: begins at  <br/>
     * Comment: refers to the beginning of a time interval, through an explicit datatype. time:hasBeginning can be used as well, if you want to associate the beginning of the interval to an explicit time point resource  <br/>
     * Domain: http://purl.org/NET/c4dm/timeline.owl#Interval  <br/>
     */
    public static final URI start = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#start");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     */
    public static final URI beginsAt = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#beginsAt");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: at date/time  <br/>
     * Comment: This property links an instant defined on the universal time line to an XSD date/time value  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#dateTime  <br/>
     */
    public static final URI atDateTime = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#atDateTime");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: sample rate  <br/>
     * Comment: associates a sample rate value to a uniform sampling map  <br/>
     * Domain: _:node15fhoafpax16  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI sampleRate = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#sampleRate");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: at (integer)  <br/>
     * Comment: A subproperty of :at, having as a specific range xsd:int  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI atInt = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#atInt");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: begins at (integer)  <br/>
     * Comment: A subproperty of :beginsAt, having xsd:int as a range  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI beginsAtInt = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#beginsAtInt");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: ends at (integer)  <br/>
     * Comment: A subproperty of :endsAt, having xsd:int as a range  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI endsAtInt = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#endsAtInt");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: duration (integer)  <br/>
     * Comment: A subproperty of :duration, having xsd:int as a range  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI durationInt = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#durationInt");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: begins at (xsd:duration)  <br/>
     * Comment: A property enabling to adress a start time point P of an interval [P,E] through the duration of the interval [0,P] on a continuous timeline  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#duration  <br/>
     */
    public static final URI beginsAtDuration = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#beginsAtDuration");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: duration (xsd:duration)  <br/>
     * Comment: A subproperty of :duration, having xsd:duration as a range  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#duration  <br/>
     */
    public static final URI durationXSD = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#durationXSD");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: ends at (xsd:duration)  <br/>
     * Comment: A property enabling to adress an end time point P of an interval [S,P] through the duration of the interval [0,P] on a continuous timeline  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#duration  <br/>
     */
    public static final URI endsAtDuration = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#endsAtDuration");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: at (year)  <br/>
     * Comment: A subproperty of :at, allowing to address a year (beginning of it for an instant, all of it for an interval)  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#gYear  <br/>
     */
    public static final URI atYear = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#atYear");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: at (year/month)  <br/>
     * Comment: A subproperty of :at, allowing to address a year/month (beginning of it for an instant, all of it for an interval)  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#gYearMonth  <br/>
     */
    public static final URI atYearMonth = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#atYearMonth");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: at (date)  <br/>
     * Comment: A subproperty of :at, allowing to address a date (beginning of it for an instant, all of it for an interval)  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#date  <br/>
     */
    public static final URI atDate = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#atDate");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: begins at (date/time)  <br/>
     * Comment: A subproperty of :beginsAt, allowing to address the beginning of an interval as a date/time  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#dateTime  <br/>
     */
    public static final URI beginsAtDateTime = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#beginsAtDateTime");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: ends at (date/time)  <br/>
     * Comment: A subproperty of :endsAt, allowing to address the end of an interval as a date/time  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#dateTime  <br/>
     */
    public static final URI endsAtDateTime = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#endsAtDateTime");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: hop size  <br/>
     * Comment: hop size, associated to a uniform windowing map  <br/>
     * Domain: _:node15fhoafpax113  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI hopSize = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#hopSize");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: window length  <br/>
     * Comment: window length, associated to a uniform windowing map  <br/>
     * Domain: _:node15fhoafpax116  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI windowLength = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#windowLength");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: at (duration)  <br/>
     * Comment: A property enabling to adress a time point P through the duration of the interval [0,P] on a continuous timeline  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#duration  <br/>
     */
    public static final URI atDuration = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#atDuration");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: at (real)  <br/>
     * Comment: subproperty of :at, having xsd:float as a range  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#float  <br/>
     */
    public static final URI atReal = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#atReal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: delay  <br/>
     * Comment: associate a shift map to a particular delay  <br/>
     * Domain: http://purl.org/NET/c4dm/timeline.owl#ShiftMap  <br/>
     */
    public static final URI delay = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#delay");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: origin  <br/>
     * Comment: associate an origin map to its origin on the domain physical timeline  <br/>
     * Domain: http://purl.org/NET/c4dm/timeline.owl#OriginMap  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#dateTime  <br/>
     */
    public static final URI origin = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#origin");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: on timeline  <br/>
     * Comment: Relates an interval or an instant to the timeline on which it is defined.

	The 29th of August, 2007 would be linked through this property to the universal timeline, whereas
	"from 2s to 5s on this particular signal" would be defined on the signal' timeline.  <br/>
     * Domain: _:node15fhoafpax1  <br/>
     * Range: http://purl.org/NET/c4dm/timeline.owl#TimeLine  <br/>
     */
    public static final URI timeline = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#timeline");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI onTimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#onTimeLine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI meets = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#meets");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI equals = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#equals");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI before = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#before");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI overlaps = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#overlaps");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI starts = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#starts");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI during = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#during");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI finishes = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#finishes");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI after = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#after");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI metBy = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#metBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI overlappedBy = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#overlappedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI startedBy = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#startedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI contains = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#contains");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI finishedBy = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#finishedBy");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: range timeline  <br/>
     * Comment: associates a timeline map to its range timeline  <br/>
     * Domain: http://purl.org/NET/c4dm/timeline.owl#TimeLineMap  <br/>
     * Range: http://purl.org/NET/c4dm/timeline.owl#TimeLine  <br/>
     */
    public static final URI rangeTimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#rangeTimeLine");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: domain timeline  <br/>
     * Comment: associates a timeline map to its domain timeline  <br/>
     * Domain: http://purl.org/NET/c4dm/timeline.owl#TimeLineMap  <br/>
     * Range: http://purl.org/NET/c4dm/timeline.owl#TimeLine  <br/>
     */
    public static final URI domainTimeLine = new URIImpl("http://purl.org/NET/c4dm/timeline.owl#domainTimeLine");
}
