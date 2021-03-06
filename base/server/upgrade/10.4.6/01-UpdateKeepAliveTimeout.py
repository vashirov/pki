# Authors:
#     Endi S. Dewata <edewata@redhat.com>
#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; version 2 of the License.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License along
# with this program; if not, write to the Free Software Foundation, Inc.,
# 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
#
# Copyright (C) 2017 Red Hat, Inc.
# All rights reserved.
#

from __future__ import absolute_import
import os
from lxml import etree

import pki


class UpdateKeepAliveTimeout(
        pki.server.upgrade.PKIServerUpgradeScriptlet):

    def __init__(self):
        super(UpdateKeepAliveTimeout, self).__init__()
        self.message = 'Update keepAliveTimeout parameter'

        self.parser = etree.XMLParser(remove_blank_text=True)

    def upgrade_instance(self, instance):

        server_xml = os.path.join(instance.conf_dir, 'server.xml')
        self.backup(server_xml)

        document = etree.parse(server_xml, self.parser)

        server = document.getroot()
        connectors = server.findall('.//Connector')

        for connector in connectors:

            # find the Secure connector
            name = connector.get('name')
            if name != 'Secure':
                continue

            # set the keepAliveTimeout parameter to 5 minutes
            connector.set('keepAliveTimeout', '300000')

        with open(server_xml, 'wb') as f:
            document.write(f, pretty_print=True, encoding='utf-8')
