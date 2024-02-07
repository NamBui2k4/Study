1. Within a production network, what is the purpose of configuring a switch with a default gateway address?

- Hosts that are connected to the switch can use the switch default gateway address to forward packets to a remote destination.
- A switch must have a default gateway to be accessible by Telnet and SSH.
- __The default gateway address is used to forward packets originating from the switch to remote networks.__
- It provides a next-hop address for all traffic that flows through the switch.

Explanation: A default gateway address allows a switch to forward packets that originate on the switch to remote networks. A default gateway address on a switch does not provide Layer 3 routing for PCs that are connected on that switch. A switch can still be accessible from Telnet as long as the source of the Telnet connection is on the local network

2. What routing table entry has a next hop address associated with a destination network?

- directly-connected routes
- local routes
- __remote routes__
- C and L source routes

Explanation: Routing table entries for remote routes will have a next hop IP address. The next hop IP address is the address of the router interface of the next device to be used to reach the destination network. Directly-connected and local routes have no next hop, because they do not require going through another router to be reached

3. When transporting data from real-time applications, such as streaming audio and video, which field in the IPv6 header can be used to inform the routers and switches to maintain the same path for the packets in the same conversation?

- Next Header
- __Flow Label__
- Traffic Class
- Differentiated Services
Explanation: The Flow Label in IPv6 header is a 20-bit field that provides a special service for real-time applications. This field can be used to inform routers and switches to maintain the same path for the packet flow so that packets will not be reordered.

4. What information does the loopback test provide?

- __The TCP/IP stack on the device is working correctly.__
- The device has end-to-end connectivity.
- DHCP is working correctly.
- The Ethernet cable is working correctly.
- The device has the correct IP address on the network.
Explanation: Because the loopback test sends packets back to the host device, it does not provide information about network connectivity to other hosts. The loopback test verifies that the host NIC, drivers, and TCP/IP stack are functioning.

5. How do hosts ensure that their packets are directed to the correct network destination?

- __They have to keep their own local routing table that contains a route to the loopback interface, a local network route, and a remote default route.​__
- They always direct their packets to the default gateway, which will be responsible for the packet delivery.
- They search in their own local routing table for a route to the network destination address and pass this information to the default gateway.
- They send a query packet to the default gateway asking for the best route.

Explanation: Hosts must maintain their own local routing table to ensure that network layer packets are directed to the correct destination network. This local table typically contains a route to the loopback interface, a route to the network that the host is connected to, and a local default route, which represents the route that packets must take to reach all remote network addresses.

6. Which parameter does the router use to choose the path to the destination when there are multiple routes available?
- __the lower metric value that is associated with the destination network__
- the lower gateway IP address to get to the destination network
- the higher metric value that is associated with the destination network
- the higher gateway IP address to get to the destination network

Answers Explanation & Hints:
When a packet arrives at the router interface, the router examines its header to determine the destination network. If there is a route for the destination network in the routing table, the router forwards the packet using that information. If there are two or more possible routes to the same destination, the metric is used to decide which route appears on the routing table. The lower the metric, the better the route.

7. What is a basic characteristic of the IP protocol?

- __connectionless__
- media dependent
- user data segmentation
- reliable end-to-end delivery

Explanation: Internet Protocol (IP) is a network layer protocol that does not require initial exchange of control information to establish an end-to-end connection before packets are forwarded. Thus, IP is connectionless and does not provide reliable end-to-end delivery by itself. IP is media independent. User data segmentation is a service provided at the transport layer.

8. What is the aim of an ARP spoofing attack?

- to flood the network with ARP reply broadcasts
- to fill switch MAC address tables with bogus addresses
- to associate IP addresses to the wrong MAC address
- to overwhelm network hosts with ARP requests
Explanation: In an ARP spoofing attack, a malicious host intercepts ARP requests and replies to them so that network hosts will map an IP address to the MAC address of the malicious host

9. What important information is examined in the Ethernet frame header by a Layer 2 device in order to forward the data onward?

- source MAC address
- source IP address
- __destination MAC address__
- Ethernet type
- destination IP address
Explanation: The Layer 2 device, such as a switch, uses the destination MAC address to determine which path (interface or port) should be used to send the data onward to the destination device.

10. Which two types of IPv6 messages are used in place of ARP for address resolution?

- anycast
- broadcast
- echo reply
- echo request
- __neighbor solicitation__
- __neighbor advertisement__
Explanation: IPv6 does not use ARP. Instead, ICMPv6 neighbor discovery is used by sending neighbor solicitation and neighbor advertisement messages

11. Which destination address is used in an ARP request frame?

- 0.0.0.0
- 255.255.255.255
- __FFFF.FFFF.FFFF__
- AAAA.AAAA.AAAA
- the physical address of the destination host
Explanation: The purpose of an ARP request is to find the MAC address of the destination host on an Ethernet LAN. The ARP process sends a Layer 2 broadcast to all devices on the Ethernet LAN. The frame contains the IP address of the destination and the broadcast MAC address, FFFF.FFFF.FFFF. The host with the IP address that matches the IP address in the ARP request will reply with a unicast frame that includes the MAC address of the host. Thus the original sending host will obtain the destination IP and MAC address pair to continue the encapsulation process for data transmission.

12. Which statement describes the treatment of ARP requests on the local link?

- They must be forwarded by all routers on the local network.
- They are received and processed by every device on the local network.
- They are dropped by all switches on the local network.
- They are received and processed only by the target device.
Explanation: One of the negative issues with ARP requests is that they are sent as a broadcast. This means all de
vices on the local link must receive and process the request.

13. What will happen if the default gateway address is incorrectly configured on a host?

- A ping from the host to 127.0.0.1 would not be successful.
- The switch will not forward packets initiated by the host.
- __The host cannot communicate with hosts in other networks.__
- The host will have to use ARP to determine the correct address of the default gateway.
- The host cannot communicate with other hosts in the local network.

14. What are two potential network problems that can result from ARP operation? (Choose two.)

- __On large networks with low bandwidth, multiple ARP broadcasts could cause data communication delays.__
- Multiple ARP replies result in the switch MAC address table containing entries that match the MAC addresses of hosts that are connected to the relevant switch port.
- Large numbers of ARP request broadcasts could cause the host MAC address table to overflow and prevent the host from communicating on the network.
- Manually configuring static ARP associations could facilitate ARP poisoning or MAC address spoofing.
- __Network attackers could manipulate MAC address and IP address mappings in ARP messages with the intent of intercepting network traffic.__

Explanation: Large numbers of ARP broadcast messages could cause momentary data communications delays. Network attackers could manipulate MAC address and IP address mappings in ARP messages with the intent to intercept network traffic. ARP requests and replies cause entries to be made into the ARP table, not the MAC address table. ARP table overflows are very unlikely. Manually configuring static ARP associations is a way to prevent, not facilitate, ARP poisoning and MAC address spoofing. Multiple ARP replies resulting in the switch MAC address table containing entries that match the MAC addresses of connected nodes and are associated with the relevant switch port are required for normal switch frame forwarding operations. It is not an ARP caused network problem.
