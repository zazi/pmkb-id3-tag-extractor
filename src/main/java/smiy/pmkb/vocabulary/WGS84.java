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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Tue Nov 02 18:53:56 CET 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/wgs84_pos.rdfs
 * namespace: http://www.w3.org/2003/01/geo/wgs84_pos#
 */
public class WGS84 {

    /** Path to the ontology resource */
    public static final String WGS84_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/wgs84_pos.rdfs";

    /**
     * Puts the WGS84 ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getWGS84Ontology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(WGS84_RESOURCE_PATH, WGS84.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + WGS84_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for WGS84 */
    public static final URI NS_WGS84 = new URIImpl("http://www.w3.org/2003/01/geo/wgs84_pos#");
    /**
     * Type: Class <br/>
     * Label: SpatialThing  <br/>
     * Comment: Anything with spatial extent, i.e. size, shape, or position.
 e.g. people, places, bowling balls, as well as abstract areas like cubes.  <br/>
     */
    public static final URI SpatialThing = new URIImpl("http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing");
    /**
     * Type: Class <br/>
     * Label: point  <br/>
     * Comment: A point, typically described using a coordinate system relative to Earth, such as WGS84. Uniquely identified by lat/long/alt. i.e.

spaciallyIntersects(P1, P2) :- lat(P1, LAT), long(P1, LONG), alt(P1, ALT),
  lat(P2, LAT), long(P2, LONG), alt(P2, ALT).

sameThing(P1, P2) :- type(P1, Point), type(P2, Point), spaciallyIntersects(P1, P2).  <br/>
     */
    public static final URI Point = new URIImpl("http://www.w3.org/2003/01/geo/wgs84_pos#Point");
    /**
     * Type: Property <br/>
     * Label: latitude  <br/>
     * Comment: The WGS84 latitude of a SpatialThing (decimal degrees).  <br/>
     * Domain: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     */
    public static final URI lat = new URIImpl("http://www.w3.org/2003/01/geo/wgs84_pos#lat");
    /**
     * Type: Property <br/>
     * Label: location  <br/>
     * Comment: The relation between something and the point, 
 or other geometrical thing in space, where it is.  For example, the realtionship between
 a radio tower and a Point with a given lat and long.
 Or a relationship between a park and its outline as a closed arc of points, or a road and
 its location as a arc (a sequence of points).
 Clearly in practice there will be limit to the accuracy of any such statement, but one would expect
 an accuracy appropriate for the size of the object and uses such as mapping .  <br/>
     * Range: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     */
    public static final URI location = new URIImpl("http://www.w3.org/2003/01/geo/wgs84_pos#location");
    /**
     * Type: Property <br/>
     * Label: longitude  <br/>
     * Comment: The WGS84 longitude of a SpatialThing (decimal degrees).  <br/>
     * Domain: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     */
    public static final URI long_ = new URIImpl("http://www.w3.org/2003/01/geo/wgs84_pos#long");
    /**
     * Type: Property <br/>
     * Label: altitude  <br/>
     * Comment: The WGS84 altitude of a SpatialThing (decimal meters 
above the local reference ellipsoid).  <br/>
     * Domain: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     */
    public static final URI alt = new URIImpl("http://www.w3.org/2003/01/geo/wgs84_pos#alt");
    /**
     * Type: Property <br/>
     * Label: lat/long  <br/>
     * Comment: A comma-separated representation of a latitude, longitude coordinate.  <br/>
     */
    public static final URI lat_long = new URIImpl("http://www.w3.org/2003/01/geo/wgs84_pos#lat_long");
}
