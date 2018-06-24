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

import com.netscape.admin.certsrv.wizard.*;
import javax.swing.*;

/**
 * The panel asks if the user wants to install the RA certificate now.
 *
 * @author Christine Ho
 * @version $Revision$, $Date$
 * @see com.netscape.admin.certsrv.config.install
 */
class WIInstallOCSPIntroPage extends WIInstallIntroPage {

    private static final String PANELNAME = "INSTALLOCSPINTROWIZARD";
    private static final String OCSPHELPINDEX = "install-ocspcert-installintro-wizard-help";

    WIInstallOCSPIntroPage(JDialog parent) {
        super(PANELNAME);
        mParent = parent;
    }

    WIInstallOCSPIntroPage(JDialog parent, JFrame adminFrame) {
        super(PANELNAME);
        mParent = parent;
        mAdminFrame = adminFrame;
    }

    public boolean initializePanel(WizardInfo info) {
        InstallWizardInfo wizardInfo = (InstallWizardInfo)info;

        if (wizardInfo.isCloning() && wizardInfo.isOCSPCloningDone())
            return false;
        if (wizardInfo.isOCSPCertLocalCA() || !wizardInfo.isOCSPInstalled() ||
          wizardInfo.isOCSPCertInstalledDone())
            return false;

        mHelpIndex = OCSPHELPINDEX;

        return super.initializePanel(info);
    }
}
