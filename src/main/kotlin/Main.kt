fun main() {
    val alphabet = listOf(
        'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н',
        'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ',
        'Э', 'Ю', 'Я'
    )

    println("Выберите действие:")
    println("1. Зашифровать текст")
    println("2. Расшифровать текст")

    val choice = readLine()?.toIntOrNull()

    when (choice) {
        1 -> encrypt(alphabet)
        2 -> decrypt(alphabet)
        else -> println("Некорректный выбор")
    }
}

fun encrypt(alphabet: List<Char>) {
    val keyword = getKeyword()
    val message = getMessage()

    val encryptedMessage = StringBuilder()

    for (i in message.indices) {
        val char = message[i].toUpperCase()
        val indexInAlphabet = alphabet.indexOf(char)

        if (indexInAlphabet != -1) {
            val keywordIndex = i % keyword.length
            val shift = alphabet.indexOf(keyword[keywordIndex].toUpperCase())
            val encryptedIndex = (indexInAlphabet + shift) % alphabet.size
            encryptedMessage.append(alphabet[encryptedIndex])
        } else {
            encryptedMessage.append(char)
        }
    }

    println("Зашифрованный текст: $encryptedMessage")
}

fun decrypt(alphabet: List<Char>) {
    val keyword = getKeyword()
    val encryptedMessage = getMessage()

    val decryptedMessage = StringBuilder()

    for (i in encryptedMessage.indices) {
        val char = encryptedMessage[i].toUpperCase()
        val indexInAlphabet = alphabet.indexOf(char)

        if (indexInAlphabet != -1) {
            val keywordIndex = i % keyword.length
            val shift = alphabet.indexOf(keyword[keywordIndex].toUpperCase())
            val decryptedIndex = (indexInAlphabet - shift + alphabet.size) % alphabet.size
            decryptedMessage.append(alphabet[decryptedIndex])
        } else {
            decryptedMessage.append(char)
        }
    }

    println("Расшифрованный текст: $decryptedMessage")
}

fun getKeyword(): String {
    print("Введите ключевое слово: ")
    return readLine().toString().toUpperCase()
}

fun getMessage(): String {
    print("Введите текст: ")
    return readLine().toString()
}
