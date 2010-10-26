/*
 * Copyright (c) 2006 - 2008 Aduna and Deutsches Forschungszentrum fuer Kuenstliche Intelligenz DFKI GmbH.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 */
package smiy.pmkb.extractor.audiodocuments.mp3.bundle;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.semanticdesktop.aperture.extractor.FileExtractorFactory;
import org.semanticdesktop.aperture.extractor.mp3.MP3FileExtractorFactory;

public class Mp3ExtractorActivator implements BundleActivator {

	private ServiceRegistration registration;

	public void start(BundleContext context) throws Exception {
		registration = context.registerService(
				FileExtractorFactory.class.getName(), new MP3FileExtractorFactory(),
				new Hashtable());
	}

	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}
}
