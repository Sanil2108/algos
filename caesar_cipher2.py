class CaesarCipher2():

    def __init__(self, shift):
        self.shift=shift
        encoder = [None] * 26
        decoder =[None] * 26
        for k in range(26):
            encoder[k] = chr((k+shift)%26 + ord('A'))
            decoder[k] = chr((k-shift)%26 + ord('A'))
        self._forward = ''.join(encoder)
        self._backward = ''.join(decoder)

    def encrypt(self, message):
        return self._transform(message, self._forward)

    def decrypt(self, secret):
        return self._transform(secret, self._backward)

    def _transform(self, message, arr):
        msg= list(message)
        for k in range(len(msg)):
            if msg[k].isupper():
                msg[k] = arr[ord(msg[k])-ord('A')]
        return ''.join(msg)
