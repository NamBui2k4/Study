1. A high school in New York (school A) is using videoconferencing technology to establish student interactions with another high school (school B) in Russia. The videoconferencing is conducted between two end devices through the Internet. The network administrator of school A configures the end device with the IP address 209.165.201.10. The administrator sends a request for the IP address for the end device in school B and the response is 192.168.25.10. Neither school is using a VPN. The administrator knows immediately that this IP will not work. Why?

- This is a loopback address.
- This is a link-local address.
- __This is a private IP address.__
- There is an IP address conflict.
Explanation: The IP address 192.168.25.10 is an IPv4 private address. This address will not be routed over the Internet, so school A will not be able to reach school B. Because the address is a private one, it can be used freely on an internal network. As long as no two devices on the internal network are assigned the same private IP, there is no IP conflict issue. Devices that are assigned a private IP will need to use NAT in order to communicate over the Internet.

2. What is the prefix for the host address 2001:DB8:BC15:A:12AB::1/64?

- 2001:DB8:BC15:A
- __2001:DB8:BC15:A:1__
- 2001:DB8:BC15:A:12
- 2001:DB8:BC15
Explanation: The network portion, or prefix, of an IPv6 address is identified through the prefix length. A /64 prefix length indicates that the first 64 bits of the IPv6 address is the network portion. Hence the prefix is 2001:DB8:BC15:A.

3. A host is transmitting a multicast. Which host or hosts will receive it?

- __a specially defined group of hosts__
- the closest neighbor on the same network
- one specific host
- directly connected network devices

4. What three blocks of addresses are defined by RFC 1918 for private network use? (Choose three.)

- 169.254.0.0/16
- __192.168.0.0/16__
- 100.64.0.0/14
- 239.0.0.0/8
- __172.16.0.0/12__
- __10.0.0.0/8__

5. A message is sent to all hosts on a remote network. Which type of message is it?
- multicast
- __directed broadcast__
- limited broadcast
- unicast

Explanation: A directed broadcast is a message sent to all hosts on a specific network. It is useful for sending a broadcast to all hosts on a nonlocal network. A multicast message is a message sent to a selected group of hosts that are part of a subscribing multicast group. A limited broadcast is used for a communication that is limited to the hosts on the local network. A unicast message is a message sent from one host to another.

6. Which address prefix range is reserved for IPv4 multicast?


- 240.0.0.0 – 254.255.255.255
- __224.0.0.0 – 239.255.255.255__
- 169.254.0.0 – 169.254.255.255
- 127.0.0.0 – 127.255.255.255
Explanation: Multicast IPv4 addresses use the reserved class D address range of 224.0.0.0 to 239.255.255.255.

7. Refer to the exhibit. Considering the addresses already used and having to remain within the 10.16.10.0/24 network range, which subnet address could be assigned to the network containing 25 hosts?comment image
![](/pictures/quest7-module_4.png)
- 10.16.10.160/26
- 10.16.10.128/28
- __10.16.10.64/27__
- 10.16.10.224/26
- 10.16.10.240/27
- 10.16.10.240/28
Explanation: Addresses 10.16.10.0 through 10.16.10.63 are taken for the leftmost network. Addresses 10.16.10.192 through 10.16.10.207 are used by the center network.The address space from 208-255 assumes a /28 mask, which does not allow enough host bits to accommodate 25 host addresses.The address ranges that are available include 10.16.10.64/26 and10.16.10.128/26. To accommodate 25 hosts, 5 host bits are needed, so a /27 mask is necessary. Four possible /27 subnets could be created from the available addresses between 10.16.10.64 and 10.16.10.191:
10.16.10.64/27
10.16.10.96/27
10.16.10.128/27
10.16.10.160/27

How to calculate the range of available addresses with /27 subnets ??

8. How many host addresses are available on the 192.168.10.128/26 network?

- 30
- 32
- 60
- __62__
- 64

Explanation: A /26 prefix gives 6 host bits, which provides a total of 64 addresses, because 26 = 64. Subtracting the network and broadcast addresses leaves 62 usable host addresses.

9. Match the subnetwork to a host address that would be included within the subnetwork. (Not all options are used.)
![](/pictures/quest9-module_4.png)

Explanation: Subnet 192.168.1.32/27 will have a valid host range from 192.168.1.33 – 192.168.1.62 with the broadcast address as 192.168.1.63
Subnet 192.168.1.64/27 will have a valid host range from 192.168.1.65 – 192.168.1.94 with the broadcast address as 192.168.1.95
Subnet 192.168.1.96/27 will have a valid host range from 192.168.1.97 – 192.168.1.126 with the broadcast address as 192.168.1.127

10. A company has a network address of 192.168.1.64 with a subnet mask of 255.255.255.192. The company wants to create two subnetworks that would contain 10 hosts and 18 hosts respectively. Which two networks would achieve that? (Choose two.)

- 192.168.1.16/28
- __192.168.1.64/27__
- 192.168.1.128/27
- __192.168.1.96/28__
- 192.168.1.192/28
Explanation: Subnet 192.168.1.64 /27 has 5 bits that are allocated for host addresses and therefore will be able to support 32 addresses, but only 30 valid host IP addresses. Subnet 192.168.1.96/28 has 4 bits for host addresses and will be able to support 16 addresses, but only 14 valid host IP addresses.

11. Which three addresses are valid public addresses? (Choose three.)

- __198.133.219.17__
- 192.168.1.245
- 10.15.250.5
- __128.107.12.117__
- 172.31.1.25
- __64.104.78.227__
Explanation: The ranges of private IPv4 addresses are as folllows:
10.0.0.0 – 10.255.255.255
172.16.0.0 – 172.31.255.255
192.168.0.0 – 192.168.255.255

12. An administrator wants to create four subnetworks from the network address 192.168.1.0/24. What is the network address and subnet mask of the second useable subnet?

- __subnetwork 192.168.1.64  , subnet mask 255.255.255.192__
- subnetwork 192.168.1.32  , subnet mask 255.255.255.240
- subnetwork 192.168.1.64  , subnet mask 255.255.255.240
- subnetwork 192.168.1.128  , subnet mask 255.255.255.192
- subnetwork 192.168.1.8  , subnet mask 255.255.255.224

Explanation: The number of bits that are borrowed would be two, thus giving a total of 4 useable subnets:
192.168.1.0
192.168.1.64
192.168.1.128
192.168.1.192
Because 2 bits are borrowed, the new subnet mask would be /26 or 255.255.255.192

13. What is the usable number of host IP addresses on a network that has a /26 mask?

- 256
- 254
- 64
- __62__
- 32
- 16
Explanation: A /26 mask is the same as 255.255.255.192. The mask leaves 6 host bits. With 6 host bits, 64 IP addresses are possible. One address represents the subnet number and one address represents the broadcast address, which means that 62 addresses can then be used to assign to network devices.

14. What source IP address does a router use by default when the traceroute command is issued?

- the highest configured IP address on the router
- a loopback IP address
- __the IP address of the outbound interface__
- the lowest configured IP address on the router
Explanation: When sending an echo request message, a router will use the IP address of the exit interface as the source IP address. This default behavior can be changed by using an extended ping and specifying a specific source IP address

15. Which protocol is used by the traceroute command to send and receive echo-requests and echo-replies?

- SNMP
- __ICMP__
- Telnet
- TCP
Explanation: Traceroute uses the ICMP (Internet Control Message Protocol) to send and receive echo-request and echo-reply messages

16.  Which ICMPv6 message is sent when the IPv6 hop limit field of a packet is decremented to zero and the packet cannot be forwarded?

- network unreachable
- __time exceeded__
- protocol unreachable
- port unreachable
Explanation: ICMPv6 uses the hop limit field in the IPv6 packet header to determine if the packet has expired. If the hop limit field has reached zero, a router will send a time exceeded message back towards the source indicating that the router cannot forward the packet.

17. Which is the compressed format of the IPv6 address 2001:0db8:0000:0000:0ab8:0001:0000:1000?

- __2001:db8::ab8:1:0:1000__
- 2001:db8::a0b0:8:1
- 2001:db8:1::ab8:0:1
- 2001:db8:0:1::8:1

18. Which IPv6 prefix is reserved for communication between devices on the same link?

- FC00::/7
- 2001::/32
- __FE80::/10__
- FDFF::/7
Explanation: IPv6 link-local unicast addresses are in the FE80::/10 prefix range and are not routable. They are used only for communications between devices on the same link.

19. 
![](/pictures/quest19-module_4.png)
Refer to the exhibit. A company is deploying an IPv6 addressing scheme for its network. The company design document indicates that the subnet portion of the IPv6 addresses is used for the new hierarchical network design, with the s ite subsection to represent multiple geographical sites of the company, the s ub-site section to represent multiple campuses at each site, and the s ubnet section to indicate each network segment separated by routers. With such a scheme, what is the maximum number of subnets achieved per sub-site ?

- 0
- 4
- __16__
- 256
Explanation: Because only one hexadecimal character is used to represent the subnet, that one character can represent 16 different values 0 through F

20. Given IPv6 address prefix 2001:db8::/48, what will be the last subnet that is created if the subnet prefix is changed to /52?

- 2001:db8:0:f00::/52
- 2001:db8:0:8000::/52
- 2001:db8:0:f::/52
- __2001:db8:0:f000::/52__
Explanation: Prefix 2001:db8::/48 has 48 network bits. If we subnet to a /52, we are moving the network boundary four bits to the right and creating 16 subnets. The first subnet is 2001:db8::/52 the last subnet is 2001:db8:0:f000::/52.

21.  What is the prefix for the host address 2001:DB8:BC15:A:12AB::1/64?

- 2001:DB8:BC15
- __2001:DB8:BC15:A__
- 2001:DB8:BC15:A:1
- 2001:DB8:BC15:A:12
Explanation: The network portion, or prefix, of an IPv6 address is identified through the prefix length. A /64 prefix length indicates that the first 64 bits of the IPv6 address is the network portion. Hence the prefix is 2001:DB8:BC15:A

22. Consider the following range of addresses:
2001:0DB8:BC15:00A0:0000::
2001:0DB8:BC15:00A1:0000::
2001:0DB8:BC15:00A2:0000::
…
2001:0DB8:BC15:00AF:0000::
The prefix-length for the range of addresses is

__answer: The prefix-length for the range of addresses is 60__

23.  Which of these addresses is the shortest abbreviation for the IP address: 3FFE:1044:0000:0000:00AB:0000:0000:0057?

- 3FFE:1044::AB::57
- 3FFE:1044::00AB::0057
- __3FFE:1044:0:0:AB::57__
- 3FFE:1044:0:0:00AB::0057
- 3FFE:1044:0000:0000:00AB::57
- 3FFE:1044:0000:0000:00AB::0057
Explanation: The rules for reducing the notation of IPv6 addresses are:
1. Omit any leading 0s (zeros) in any hextet.
2. Replace any single, contiguous string of one or more 16-bit hextets consisting of all zeros with a double colon (::) .
3. The double colon (::) can only be used once within an address

24. What type of IPv6 address is FE80::1?

- loopback
- __link-local__
- multicast
- global unicast
Explanation: Link-local IPv6 addresses start with FE80::/10, which is any address from FE80:: to FEBF::. Link-local addresses are used extensively in IPv6 and allow directly connected devices to communicate with each other on the link they share.

25. A network administrator has received the IPv6 prefix 2001:DB8::/48 for subnetting. Assuming the administrator does not subnet into the interface ID portion of the address space, how many subnets can the administrator create from the /48 prefix?

- 16
- 256
- 4096
- __65536__
Explanation: With a network prefix of 48, there will be 16 bits available for subnetting because the interface ID starts at bit 64. Sixteen bits will yield 65536 subnets.

