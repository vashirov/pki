// --- BEGIN COPYRIGHT BLOCK ---
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; version 2 of the License.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License along
// with this program; if not, write to the Free Software Foundation, Inc.,
// 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
//
// (C) 2007 Red Hat, Inc.
// All rights reserved.
// --- END COPYRIGHT BLOCK ---
package com.netscape.admin.certsrv.config.install;

import javax.swing.*;
import com.netscape.admin.certsrv.wizard.*;
import com.netscape.certsrv.common.*;

/**
 * Display the OCSP signing certificate request result
 *
 * @author Michelle Zhao
 * @version $Revision$, $Date$
 * @see com.netscape.admin.certsrv.config.install
 */
class WIOCSPRequestResultPage extends WIRequestResultPage {

    WIOCSPRequestResultPage(JDialog parent) {
        super(parent);
    }

    WIOCSPRequestResultPage(JDialog parent, JFrame adminFrame) {
        super( parent, adminFrame);
    }

    public boolean initializePanel(WizardInfo info) {
        InstallWizardInfo wizardInfo = (InstallWizardInfo)info;
        if (wizardInfo.isCloning() && wizardInfo.isOCSPCloningDone())
            return false;

        if (wizardInfo.isOCSPCertLocalCA() || !wizardInfo.isOCSPInstalled() ||
            wizardInfo.isOCSPLocalCertDone() ||
			(wizardInfo.isOCSPCertRequestSucc() && wizardInfo.isOCSPReqResultDisplayed()) ||
			wizardInfo.isOCSPCertInstalledDone())
            return false;

		wizardInfo.setOCSPReqResultDisplayed(Constants.TRUE);
        return super.initializePanel(info);
	}

}



