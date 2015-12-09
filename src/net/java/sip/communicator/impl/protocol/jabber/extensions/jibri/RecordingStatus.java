/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.java.sip.communicator.impl.protocol.jabber.extensions.jibri;

import net.java.sip.communicator.impl.protocol.jabber.extensions.*;

/**
 * The packet extension added to Jicofo presence to broadcast current recording
 * status to all conference participants.
 *
 */
public class RecordingStatus
    extends AbstractPacketExtension
{
    /**
     * The namespace of this packet extension.
     */
    public static final String NAMESPACE = JibriIq.NAMESPACE;

    /**
     * XML element name of this packet extension.
     */
    public static final String ELEMENT_NAME = "jibri-recording-status";

    private static final String STATUS_ATTRIBUTE = "status";

    public RecordingStatus()
    {
        super(NAMESPACE, ELEMENT_NAME);
    }

    public JibriIq.Status getStatus()
    {
        String statusAttr = getAttributeAsString(STATUS_ATTRIBUTE);

        return JibriIq.Status.parse(statusAttr);
    }

    public void setStatus(JibriIq.Status status)
    {
        setAttribute(STATUS_ATTRIBUTE, String.valueOf(status));
    }
}
