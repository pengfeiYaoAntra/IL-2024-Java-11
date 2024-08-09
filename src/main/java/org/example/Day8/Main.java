package org.example.Day8;

/**
 * OSI model
 *1: application layer: this a layer close to end-user (you)
 * 2: presentation: it can be used for transforming data into another format(encrypt, decrypt, compression)
 * 3:session layer: it can be used for establish connection, maintenance, terminate
 * 4: transport layer: you can know data is send to someone else
 * 5: network layer: you can know where you need to send data (IP address) -> routing, logical addressing
 * 6: data link layer: data can be encoded or decoded into bits -> hello -> 101010101010
 * 7: physical layer: it converts data bits into electrical impulses or radio signals
 *
 *
 * TCP/IP model -> 4 layers
 * application layer is the same as osi model
 * transport layer is the same sa osi model
 * network layer: cantians source and destination ip address and send data over the network
 * network access layer: transfers the packets between different hosts
 *
 *
 * in TCP protocol:
 * SYN: used to establish connection between client and server
 * ACK: let us know the other side that has received the SYN
 * FIN: to terminate the connection
 * SYN-ACK: SYN message from local device and ack of earlier packet
 * SEQ: keep track how many data it has send and make sure data is deliverd in the correct order
 * ACKnum: next sequence number you expect to receive
 *
 *
 *          client state            client                      server              server state
 *          LISTEN                                                                      LISTEN
 *                              SYN = 1, Seq = x --->
 *          SYN_SENT
 *                                                                                      SYN_RCVD
 *                                           <----ACK =1,ACKnum=x+1, Seq =y, SYN =1
 *          ESTAB                   ACK = 1, ACKnum = y + 1 ----->
 *                                                                                       ESTAB
 * what if the first handshake is lost
 * the client will resend SYN to server side
 * what if the second handshake is lost
 * the client will resend SYN and server will resend everything -> back to first step
 *
 *TCP connection terminate
 *
 *  client state            client                               server              server state
 *      ESTAB                                                                            ESTAB
 *                clientSocket.close() -> FIN = 1, seq =x --->
 *
 *      FIN_WAIT_1
 *      FIN_WAIT_2                           <------------ ACK=1, ACKnum = x+1
 *                                                                                       close_WAIT
 *                       #### server still can send data to client side######
 *                                                      <---- FIN = 1, seq = z             LAST_ACK
 *       TIMED_WAIT
 *                      ACK = 1, ACKnum = Z + 1 --->
 *                                                                                          CLOSED
 *       CLOSED( client wait for some time)
 *
 *
 *  what if the first handshake is lost
 *  the client will resend fin
 *  what if the second handshake is lost
 *  resend FIN and ACK
 *  what if the third one is lost
 *  resend FIN at the server side
 *  what if the fourth one is lost
 *  the server side resend FIN
 *
 *
 *
 *
 *
 *  UDP
 * it is used for time-sensitive transmissions , less reliable than tcp
 *
 *
 * DNS
 *  used to transfer human readable domain name to IP address -> www.google.com -> 123.123.123.123
 *
 *  1: user enter www.google.com into your web
 *  2: DNS server: internet service provider -> ATT, version ...
 *  3: DNS server will lookup ip address with www.google.com. if ATT cached this ip address -> send back to you
 *  if ATT does not cache this ip address -> will go to root server -> and resolve ip address for you
 *  4: ip address back to ATT(DNS server) and cache it
 *  5: back to you
 *
 *  HTTP
 *  allows us to send or fetch data, such as HTML, Video, image, document. used for any data exchange one the webside
 *
 *  stateless -> each request is treated independently
 *
 *  **** http methods ->
 *      GET: retrieve data from your resources
 *      HEAD: same to GET, you will only get header information
 *      POST: create new data if it does not exit, otherwise will update data
 *      PUT: update whole data
 *      patch: update part of data
 *      delete: delete data
 *      ...
 *      http status:
 *
 *      2 kinds: 1: your is received  - >
 *                  1XX (100 - 199) -> your request is received and you can continue next step
 *                      100 -> continue:
 *
 *                  2XX(200 - 299)
 *                  200 OK
 *                  201 you request is received and create a new resource
 *                  204: you request is received, not returning
 *
 *                  3XX(300 - 399)
 *                      redirection
 *                      301 old URL has been changed permanently
 *                      302, the server found a temporary redirection URL, and redirection to it
 *                      ...
 *
 *
 *              2: errors
 *                      client side error: 4XX (400 - 499)
 *                          404: not found
 *                          400 bad request
 *                          401: unauthorized
 *
 *                          server side error 5XX
 *                          500: interanl server error
 *                          503 :  service not available
 *                          504: gateway timeout
 *
 *
 *
 *
 *       encryption algo:
 *       1: symmetric algorithm: use the same key for both encryption and decryption
 *
 *       2: Asymmetric algorithm: use different key for encryption and decryption
 *                  public key for encrypt and private key for decrypt
 *
 *        HTTPS -> HTTP + SSL/TLS
 *
 *        1: client wants to connect
 *              TCP
 *        2: server sends certificate  and public key-> CA stands for certificate authority
 *        3: client will do verification for CA
 *
 *        4: client side will generate pre-master secret
 *          pre-master secret used for generating session key
 *          session key used for encryption
 *          5: secure key exchange
 *              client encrypt pre-master secret with public key
 *              server side will decrypt pre-master secret with private key
 *
 *          6: use pre-master secret to generate session key
 *          7: data exchange
 *                  data is encrypted and decrypted on each sides with session key
 *
 *
 *
 *
 *
 *
 *
 */
public class Main {

}
