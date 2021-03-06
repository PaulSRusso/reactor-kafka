/*
 * Copyright (c) 2016 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.kafka.receiver.internals;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import reactor.kafka.receiver.ReceiverRecord;
import reactor.kafka.receiver.ReceiverOffset;

class CommittableRecord<K, V> implements ReceiverRecord<K, V> {

    private final ConsumerRecord<K, V> consumerRecord;
    private final ReceiverOffset receiverOffset;

    public CommittableRecord(ConsumerRecord<K, V> consumerRecord, ReceiverOffset receiverOffset) {
        this.consumerRecord = consumerRecord;
        this.receiverOffset = receiverOffset;
    }

    public ConsumerRecord<K, V> record() {
        return consumerRecord;
    }

    public ReceiverOffset offset() {
        return receiverOffset;
    }

    @Override
    public String toString() {
        return String.valueOf(consumerRecord);
    }
}