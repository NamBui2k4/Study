1. In addition to the cable length, what two factors could interfere with the communication carried over UTP cables? (Choose two.)

- __crosstalk__
- bandwidth
- size of the network
- signal modulation technique
- __electromagnetic interference__

Explanation: Copper media is widely used in network communications. However, copper media is limited by distance and signal interference. Data is transmitted on copper cables as electrical pulses. The electrical pulses are susceptible to interference from two sources:
- Electromagnetic interference (EMI) or radio frequency interference (RFI) – EMI and RFI signals can distort and corrupt the data signals being carried by copper media.
- Crosstalk – Crosstalk is a disturbance caused by the electric or magnetic fields of a signal on one wire interfering with the signal in an adjacent wire.

2. What are two characteristics of fiber-optic cable? (Choose two.)

- __It is not affected by EMI or RFI.__
- Each pair of cables is wrapped in metallic foil.
- It combines the technique of cancellation, shielding, and twisting to protect data.
- It typically contains 4 pairs of fiber-optic wires.
- __It is more expensive than UTP cabling is.__

3. Which two devices commonly affect wireless networks? (Choose two.)

- Blu-ray players
home theaters
- __cordless phones__
- __microwaves__
- incandescent light bulbs
- external hard drives
Explanation: Radio Frequency Interference (RFI) is the interference that is caused by radio transmitters and other devices that are transmitting in the same frequency

4. Refer to the exhibit. What is wrong with the displayed termination?

![](/pictures/twisted-pair.jpg)

- The woven copper braid should not have been removed.
- The wrong type of connector is being used.
- The untwisted length of each wire is too long.
- The wires are too thick for the connector that is used.
Explanation: When a cable to an RJ-45 connector is terminated, it is important to ensure that the untwisted wires are not too long and that the flexible plastic sheath surrounding the wires is crimped down and not the bare wires. None of the colored wires should be visible from the bottom of the jack.


5. A network administrator is measuring the transfer of bits across the company backbone for a mission critical financial application. The administrator notices that the network throughput appears lower than the bandwidth expected. Which three factors could influence the differences in throughput? (Choose three.)
- 
- __the amount of traffic that is currently crossing the network__
- the sophistication of the encapsulation method applied to the data
- __the type of traffic that is crossing the network__
- __the latency that is created by the number of network devices that the data is crossing__
- the bandwidth of the WAN connection to the Internet
- the reliability of the gigabit Ethernet infrastructure of the backbone
Explanation: Throughput usually does not match the specified bandwidth of physical links due to multiple factors. These factors include, the amount of traffic, type of traffic, and latency created by the network devices the data has to cross.

6. With the use of unshielded twisted-pair copper wire in a network, what causes crosstalk within the cable pairs?

- __the magnetic field around the adjacent pairs of wire__
- the use of braided wire to shield the adjacent wire pairs
- the reflection of the electrical wave back from the far end of the cable
- the collision caused by two nodes trying to use the media simultaneously
Explanation: Crosstalk is a type of noise, or interference that occurs when signal transmission on one wire interferes with another wire. When current flows through a wire a magnetic field is produced. The produced magnetic field will interface the signal carried in the adjacent wire.

7. What is the purpose of the FCS field in a frame?

- to obtain the MAC address of the sending node
- to verify the logical address of the sending node
- to compute the CRC header for the data field
- to determine if errors occurred in the transmission and reception

Explanation: The FCS field in a frame is used to detect any errors in the transmission and receipt of a frame. This is done by comparing the CRC value within the frame against a computed CRC value of the frame. If the two values do not match, then the frame is discarded.

8. A network administrator is connecting two modern switches using a straight-through cable. The switches are new and have never been configured. Which three statements are correct about the final result of the connection? (Choose three.)

- __The link between the switches will work at the fastest speed that is supported by both switches.__
- __The link between switches will work as full-duplex.__
- If both switches support different speeds, they will each work at their own fastest speed.
- __The auto-MDIX feature will configure the interfaces eliminating the need for a crossover cable.__
- The connection will not be possible unless the administrator changes the cable to a crossover cable.
- The duplex capability has to be manually configured because it cannot be negotiated.
Explanation: Modern switches can negotiate to work in full-duplex mode if both switches are capable. They will negotiate to work using the fastest possible speed and the auto-MDIX feature is enabled by default, so a cable change is not needed.

9. Which frame forwarding method receives the entire frame and performs a CRC check to detect errors before forwarding the frame?

- cut-through switching
- __store-and-forward switching__
- fragment-free switching
- fast-forward switching
Explanation: Fast-forward and fragment-free switching are variations of cut-through switching, which begins to forward the frame before the entire frame is received.

10. What is the auto-MDIX feature?

- __It enables a device to automatically configure an interface to use a straight-through or a crossover cable.__
- It enables a device to automatically configure the duplex settings of a segment.
- It enables a device to automatically configure the speed of its interface.
- It enables a switch to dynamically select the forwarding method.

11. What are two actions performed by a Cisco switch? (Choose two.)

- building a routing table that is based on the first IP address in the frame header
- __using the source MAC addresses of frames to build and maintain a MAC address table__
- forwarding frames with unknown destination IP addresses to the default gateway
- __utilizing the MAC address table to forward frames via the destination MAC address__
- examining the destination MAC address to add new entries to the MAC address table
Explanation: Important actions that a switch performs are as follows:

12. Which switching method has the lowest level of latency?

- cut-through
- store-and-forward
- fragment-free
- fast-forward

Explanation: Fast-forward switching begins to forward a frame after reading the destination MAC address, resulting in the lowest latency. Fragment-free reads the first 64 bytes before forwarding. Store-and-forward has the highest latency because it reads the entire frame before beginning to forward it. Both fragment-free and fast-forward are types of cut-through switching

13. What is one advantage of using the cut-through switching method instead of the store-and-forward switching method?

- has a positive impact on bandwidth by dropping most of the invalid frames
- makes a fast forwarding decision based on the source MAC address of the frame
- __has a lower latency appropriate for high-performance computing applications​__
- provides the flexibility to support any mix of Ethernet speeds
Explanation: Cut-through switching provides lower latency switching for high-performance computing (HPC) applications. Cut-through switching allows more invalid frames to cross the network than store-and-forward switching. The cut-through switching method can make a forwarding decision as soon as it looks up the destination MAC address of the frame

14. Which switching method uses the CRC value in a frame?
- cut-through
- fast-forward
- fragment-free
- store-and-forward
Explanation: When the store-and-forward switching method is used, the switch receives the complete frame before forwarding it on to the destination. The cyclic redundancy check (CRC) part of the trailer is used to determine if the frame has been modified during transit.​​ In contrast, a cut-through switch forwards the frame once the destination Layer 2 address is read. Two types of cut-through switching methods are fast-forward and fragment-free.

15. What are two examples of the cut-through switching method? (Choose two.)

- store-and-forward switching
- __fast-forward switching__
- CRC switching
- __fragment-free switching__
- QOS switching

16. Which address is a multicast MAC address?

- 0-07-E9-00-00-D4
- __01-00-5E-00-00-C8__
- FF-FF-FF-FF-FF-FF
- FF-FF-FF-01-00-5E
Explanation: All multicast MAC addresses start with 01-00-5E

17. Which advantage does the store-and-forward switching method have compared with the cut-through switching method?
- collision detecting
- frame error checking
- faster frame forwarding
- frame forwarding using IPv4 Layer 3 and 4 information
Explanation: A switch using the store-and-forward switching method performs an error check on an incoming frame by comparing the FCS value against its own FCS calculations after the entire frame is received. In comparison, a switch using the cut-through switching method makes quick forwarding decisions and starts the forwarding process without waiting for the entire frame to be received. Thus a switch using cut-through switching may send invalid frames to the network. The performance of store-and-forward switching is slower compared to cut-through switching performance. Collision detection is monitored by the sending device. Store-and-forward switching does not use IPv4 Layer 3 and 4 information for its forwarding decisions.

18. What OSI physical layer term describes the physical medium for microwave transmissions?
- __air__
- goodput
- latency
- throughput