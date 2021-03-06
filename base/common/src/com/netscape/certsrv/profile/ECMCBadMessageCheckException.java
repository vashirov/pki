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
// (C) 2017 Red Hat, Inc.
// All rights reserved.
// --- END COPYRIGHT BLOCK ---
package com.netscape.certsrv.profile;

/**
 * This represents a profile specific exception for handling
 * CMC badMessageCheck condition.
 * The framework raises this exception when a request fails various
 * checks
 * <p>
 *
 * @version $Revision$, $Date$
 */
public class ECMCBadMessageCheckException extends EProfileException {

    /**
     *
     */
    private static final long serialVersionUID = 1353005739159030604L;

    /**
     * Creates an exception.
     *
     * @param msg localized message that will be
     *            displayed to end user.
     */
    public ECMCBadMessageCheckException(String msg) {
        super(msg);
    }

    public ECMCBadMessageCheckException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ECMCBadMessageCheckException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

}
