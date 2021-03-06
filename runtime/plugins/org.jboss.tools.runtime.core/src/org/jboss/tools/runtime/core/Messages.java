/******************************************************************************* 
 * Copyright (c) 2007 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 
package org.jboss.tools.runtime.core;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.jboss.tools.runtime.core.Messages"; //$NON-NLS-1$

	/* Standard and re-usable */
	public static String ECFExamplesTransport_Downloading;
	public static String ECFExamplesTransport_Internal_Error;
	public static String ECFExamplesTransport_IO_error;
	public static String ECFExamplesTransport_Loading;
	public static String ECFExamplesTransport_ReceivedSize_Of_FileSize_At_RatePerSecond;
	public static String ECFExamplesTransport_Server_redirected_too_many_times;

	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	private Messages() {
	}
}
