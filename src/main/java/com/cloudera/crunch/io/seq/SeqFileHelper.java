/**
 * Copyright (c) 2011, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */
package com.cloudera.crunch.io.seq;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

import com.cloudera.crunch.MapFn;
import com.cloudera.crunch.type.PType;
import com.cloudera.crunch.type.writable.WritableType;

public class SeqFileHelper {
  static <T> Writable newInstance(PType<T> ptype, Configuration conf) {
	return (Writable) ReflectionUtils.newInstance(
	    ((WritableType) ptype).getSerializationClass(), conf); 
  }
  
  static <T> MapFn<Writable, T> getInputMapFn(PType<T> ptype) {
	return ptype.getDataBridge().getInputMapFn();
  }
}
