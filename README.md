# rest-api-kafka
to connect to kafka to post/fetch data
Preconditions:
kubernetes cluster is already up as per last hw. 
angular and rest api apps are from previous project with some minor changes.

install helm
$ curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3
$ chmod 700 get_helm.sh
$ ./get_helm.sh

with helm install strimzi
helm install strimzi/strimzi-kafka-operator \
--name my-strimzi-release \
--version 0.8.2

using strimzi follow instructins to install kafka as per: 
https://strimzi.io/docs/operators/master/quickstart.html#proc-product-downloads-str

##########################################################################
Log in to the Kubernetes cluster using an account that has cluster admin privileges.

Create a new kafka namespace for the Strimzi Kafka Cluster Operator.

kubectl create ns kafka
Modify the installation files to reference the kafka namespace where you will install the Strimzi Kafka Cluster Operator.
sed -i 's/namespace: .*/namespace: kafka/' install/cluster-operator/*RoleBinding*.yaml
Create a new my-kafka-project namespace where you will deploy your Kafka cluster.

kubectl create ns my-kafka-project
Edit the install/cluster-operator/060-Deployment-strimzi-cluster-operator.yaml file and set the STRIMZI_NAMESPACE environment variable to the namespace my-kafka-project.

# ...
env:
- name: STRIMZI_NAMESPACE
  value: my-kafka-project
# ...

Deploy the CRDs and role-based access control (RBAC) resources to manage the CRDs.

kubectl apply -f install/cluster-operator/ -n kafka
Give permission to the Cluster Operator to watch the my-kafka-project namespace.

kubectl apply -f install/cluster-operator/020-RoleBinding-strimzi-cluster-operator.yaml -n my-kafka-project
kubectl apply -f install/cluster-operator/032-RoleBinding-strimzi-cluster-operator-topic-operator-delegation.yaml -n my-kafka-project
kubectl apply -f install/cluster-operator/031-RoleBinding-strimzi-cluster-operator-entity-operator-delegation.yaml -n my-kafka-project

Creating a cluster:
Log in to the Kubernetes cluster as a non-privileged user.

Create a new my-cluster Kafka cluster with three(3) ZooKeeper and three(3) Kafka brokers as per the HW4_my-project.yaml file attached.


Use persistent-claim storage

Expose the Kafka cluster outside of the Kubernetes cluster using an external listener configured to use a nodeport.

Wait for the cluster to be deployed:

kubectl wait kafka/my-cluster --for=condition=Ready --timeout=300s -n my-kafka-project
When your cluster is ready, create a topic to publish and subscribe from your external client as per hw4_topic.yaml attached.

Downlaod and install kafka on local m/c

Find the port of the bootstrap service:

kubectl get service my-cluster-kafka-external-bootstrap -n my-kafka-project -o=jsonpath='{.spec.ports[0].nodePort}{"\n"}'
Find the IP address of the Minikube node:

kubectl get nodes --output=jsonpath='{range .items[*]}{.status.addresses[?(@.type=="InternalIP")].address}{"\n"}{end}'
Open a terminal, and start the Kafka console producer with the topic my-topic:

bin/kafka-console-producer.sh --broker-list <node-address>:_<node-port>_ --topic my-topic

in our case it's: 34.86.90.135:30807

open 

Type your message into the console where the producer is running.

Open a new terminal tab or window, and start the consumer to receive the messages:

bin/kafka-console-consumer.sh --bootstrap-server 34.86.90.135:30807 --topic my-topic --from-beginning

Create the following my-topic custom resource definition with 3 partitions and replication factor 1 in the my-cluster Kafka cluster:
#############################################################################

references update rest api to point to bootstrap-server and make other changes, update angular project ot ne rest project
download strimzi kafka:
https://strimzi.io/docs/operators/master/quickstart.html#proc-product-downloads-str
