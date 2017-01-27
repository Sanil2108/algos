class CaesarCipher():

    @staticmethod
    def create_caesar_cipher(offset, string):
        char_array = list(string)
        for i in range(len(char_array)):
            char_array[i] = chr((ord(char_array[i])-97+offset)%26+97)
        return ''.join(char_array)

    @staticmethod
    def decrypt_caesar_cipher(offset, string):
        char_array = list(string)
        for i in range(len(char_array)):
            char_array[i] = chr((ord(char_array[i])-97-offset)%26+97)
        return ''.join(char_array)

    def __len__(self):
        return 0

    def __str__(self):
        return '''Can't'''

    def __init__(self, string, offset):
        self.offset = offset
        self.string = string

    def encrypt(self):
        self.encrypted_string = CaesarCipher.create_caesar_cipher(self.offset, self.string)

    def decrypt(self):
        return CaesarCipher.decrypt_caesar_cipher(self.offset, self.encrypted_string)
