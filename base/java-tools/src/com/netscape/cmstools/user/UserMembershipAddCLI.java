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
// (C) 2013 Red Hat, Inc.
// All rights reserved.
// --- END COPYRIGHT BLOCK ---

package com.netscape.cmstools.user;

import com.netscape.certsrv.user.UserMembershipData;
import com.netscape.cmstools.cli.CLI;
import com.netscape.cmstools.cli.MainCLI;

/**
 * @author Endi S. Dewata
 */
public class UserMembershipAddCLI extends CLI {

    public UserCLI parent;

    public UserMembershipAddCLI(String name, UserCLI parent) {
        super(name, "Add user membership");
        this.parent = parent;
    }

    public UserMembershipAddCLI(UserCLI parent) {
        this("membership-add", parent);
    }

    public void printHelp() {
        formatter.printHelp(parent.name + "-" + name + " <User ID> <Group ID>", options);
    }

    public void execute(String[] args) throws Exception {

        if (args.length != 2) {
            printHelp();
            System.exit(1);
        }

        String userID = args[0];
        String groupID = args[1];

        UserMembershipData userMembershipData = parent.client.addUserMembership(userID, groupID);

        MainCLI.printMessage("Added membership in \""+groupID+"\"");

        UserCLI.printUserMembership(userMembershipData);
    }
}
