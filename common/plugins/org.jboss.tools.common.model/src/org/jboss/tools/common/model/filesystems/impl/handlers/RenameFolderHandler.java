/*******************************************************************************
 * Copyright (c) 2007 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/ 
package org.jboss.tools.common.model.filesystems.impl.handlers;

import java.util.Properties;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.jboss.tools.common.meta.action.impl.handlers.DefaultEditHandler;
import org.jboss.tools.common.model.XModelException;
import org.jboss.tools.common.model.XModelObjectConstants;
import org.jboss.tools.common.model.XModelObject;
import org.jboss.tools.common.model.filesystems.impl.FolderImpl;

public class RenameFolderHandler extends DefaultEditHandler {

	public void executeHandler(XModelObject object, Properties prop) throws XModelException {
		FolderImpl f = (FolderImpl)object;
		f.save();
        Properties p = extractProperties(data[0]);
        String name = p.getProperty(XModelObjectConstants.ATTR_NAME);
        rename0(f, name);
        f.save();
	}
	
	void rename0(FolderImpl f, String name) throws XModelException {
		IFolder folder =  (IFolder)f.getResource();
		String n1 = f.get(XModelObjectConstants.XML_ATTR_NAME);
		f.set(XModelObjectConstants.XML_ATTR_NAME, name);
		String n2 = f.get(XModelObjectConstants.XML_ATTR_NAME);
		if(!n2.equals(n1)) {
			try {
				folder.move(new Path(folder.getParent().getFullPath() + XModelObjectConstants.SEPARATOR + name), true, null);
				f.setModified(true);
			} catch (CoreException e) {
				f.set(XModelObjectConstants.XML_ATTR_NAME, n1);
				throw new XModelException(e);
			}
		}			
	}
}
