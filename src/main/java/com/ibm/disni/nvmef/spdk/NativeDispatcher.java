/*
 * jVerbs: RDMA verbs support for the Java Virtual Machine
 *
 * Author: Jonas Pfefferle <jpf@zurich.ibm.com>
 *
 * Copyright (C) 2016, IBM Corporation
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
 *
 */

package com.ibm.disni.nvmef.spdk;

import com.ibm.disni.util.DiSNILogger;
import org.slf4j.Logger;

import java.util.ArrayList;

public class NativeDispatcher {
    private static final Logger logger = DiSNILogger.getLogger();

    static {
        System.loadLibrary("disni");
    }

    public native int _nvme_probe(int type, int addressFamily, String address, String serviceId, String subsystemNQN, long[] controllerIds);

    public native int _nvme_ctrlr_get_num_ns(long controller);

    public native long _nvme_ctrlr_get_ns(long controller, int namespaceId);

    public native void _nvme_ctrlr_get_data(long controller, long buffer);

    public native long _nvme_ctrlr_alloc_io_qpair(long controller, int priority);

    public native boolean _nvme_ns_is_active(long namespace);

    public native long _nvme_ns_get_size(long namespace);
    
}
