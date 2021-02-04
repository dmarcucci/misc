import groovy.cli.commons.CliBuilder

CliBuilder cliBuilder = new CliBuilder(usage: 'groovy GroovyTipsAndTricksPt1Demo <exampleName>')

List arguments = cliBuilder.parse(args).arguments()

if (arguments.size() == 1) {
    String exampleName = arguments.first()

    int number = 5
    String emptyString = ""
    String character = "+"
    Integer nullVariable = null

    Closure compareIds = { a, b -> a.id <=> b.id }
    Closure printHelloWorld = { println 'Hello world!' }

    List<String> originalList = ["b", "a", "c"]
    List<String> additionalList = ["f", "e", "d"]
    List<String> listWithDuplicates = ['a', 'b', 'c', 'd', 'a', 'f', 'g', 'a', 'i', 'j', 'k', 'l', 'a', 'n', 'o', 'd']

    Map map = [a: 1, b: 2, c: 3, d: 4, e: 5]

    List<Map> listOfMaps = [[id: 3], [id: 2], [id: 5], [id: 1]]
    List<List> listOfList = [[1, 2], [3, 4], [5, 6]]
    List<Integer> listOfIntegers = [1, 2, 3, 4, 5, 6]
    List<String> listOfStrings = ['a', 'b', 'c', 'd', 'e', 'f']

    String example = ""

    switch (exampleName) {
        case 'plus':
            example += "originalList = $originalList\n"
            example += "additionalList = ${additionalList}\n"
            List originalPlusAdditional = originalList + additionalList
            example += "originalList + additionalList: $originalPlusAdditional\n"
            example += "originalList (after) = $originalList\n"
            break
        case 'addAll':
            example += "originalList = $originalList\n"
            example += "additionalList = ${additionalList}\n"
            originalList.addAll(additionalList)
            example += "originalList (after originalList.addAll(additionalList)) = $originalList\n"
            break
        case 'leftShift':
            example += "originalList = $originalList\n"
            example += "additionalList = ${additionalList}\n"
            originalList << additionalList
            example += "originalList (after originalList << additionalList) = $originalList\n"
            break
        case 'minus':
            example += "originalList = $originalList\n"
            List originalMinusElement = originalList - "b"
            example += "originalList - 'b': $originalMinusElement\n"
            example += "originalList (after) = $originalList\n\n"
            example += "originalList = $originalList\n"
            List originalMinusList = originalList - ['b', 'c']
            example += "originalList - ['b', 'c']: $originalMinusList\n"
            example += "originalList (after) = $originalList\n"
            break
        case 'multiply':
            example += "String character = $character\n"
            example += "int number = $number\n\n"
            String result = character * number
            example += "$character * $number: $result\n"
            break
        case 'sort':
            example += "originalList = $originalList\n"
            example += "originalList.sort(false): ${originalList.sort(false)}\n"
            example += "originalList (after) = $originalList\n\n"
            example += "originalList = $originalList\n"
            example += "originalList.sort() / originalList.sort(true): ${originalList.sort()}\n"
            example += "originalList (after) = $originalList\n\n"
            example += "------------------------------------\n\n"
            example += "Closure compareIds = { a, b -> a.id <=> b.id }\n\n"
            example += "listOfMaps = $listOfMaps\n"
            example += "listOfMaps.sort(false, compareIds): ${listOfMaps.sort(false, compareIds)}\n"
            example += "listOfMaps (after) = $listOfMaps\n\n"
            example += "listOfMaps = $listOfMaps\n"
            example += "listOfMaps.sort(true, compareIds): ${listOfMaps.sort(true, compareIds)}\n"
            example += "listOfMaps (after) = $listOfMaps\n"
            break
        case 'times':
            example += "Closure printHelloWorld = { println 'Hello world!' }\n"
            example += "int number = $number\n\n"
            example += "number.times(printHelloWorld) / number.times { println 'Hello world!' }:"
            break
        case 'toBigDecimal':
            example += "int number = $number\n"
            example += "number instanceof Integer: ${number instanceof Integer}\n\n"
            example += "number.toBigDecimal(): ${number.toBigDecimal()}\n"
            example += "number.toBigDecimal() instanceof Integer: ${number.toBigDecimal() instanceof Integer}\n"
            example += "number.toBigDecimal() instanceof BigDecimal: ${number.toBigDecimal() instanceof BigDecimal}\n"
            break
        case 'toString':
            example += "int number = $number\n"
            example += "number instanceof Integer: ${number instanceof Integer}\n\n"
            example += "\"\$number\": ${"$number"}\n"
            example += "\"\$number\" instanceof Integer: ${"$number" instanceof Integer}\n"
            example += "\"\$number\" instanceof GString: ${"$number" instanceof GString}\n"
            break
        case 'with ?':
        case 'without ?':
            example += "Integer nullVariable = $nullVariable\n"
            if (exampleName.startsWith('without')) {
                try {
                    example += "nullVariable.intValue(): ${nullVariable.intValue()}\n"
                } catch (Exception e) {
                    example += "$e\n"
                }
            } else {
                example += "nullVariable?.intValue(): ${nullVariable?.intValue()}\n"
            }
            break
        case 'collect':
            example += "originalList = $originalList\n"
            example += "originalList.collect { it * 2 }: ${originalList.collect { it * 2}}\n\n"
            example += "listOfMaps = $listOfMaps\n"
            example += "listOfMaps.collect { it.id }: ${listOfMaps.collect { it.id }}\n"
            break
        case 'collectMany':
            example += "listOfList = $listOfList\n"
            example += "listOfList.collectMany { it * 2 }: ${listOfList.collectMany { it * 2 }}\n"
            break
        case 'collectEntries':
            example += "map = $map\n"
            example += "map.collectEntries { k, v -> [v, k] }: ${map.collectEntries { k, v -> [v, k] } }\n"
            example += "map (after) = $map\n\n"
            example += "originalList = $originalList\n"
            example += "originalList.collectEntries { [originalList.indexOf(it), it] }: " +
                    "${originalList.collectEntries { [originalList.indexOf(it), it] }}\n"
            example += "originalList (after) = $originalList\n"
            break
        case 'find':
            example += "map = $map\n"
            example += "map.find { k, v -> v % 2 == 0}: ${map.find { k, v -> v % 2 == 0} }\n\n"
            example += "listOfList = $listOfList\n"
            example += "listOfList.find { it.sum() > 5 }: ${listOfList.find { it.sum() > 5 }}\n"
            break
        case 'findAll':
            example += "map = $map\n"
            example += "map.findAll { k, v -> v % 2 == 0}: ${map.findAll { k, v -> v % 2 == 0} }\n\n"
            example += "listOfList = $listOfList\n"
            example += "listOfList.findAll { it.sum() > 5 }: ${listOfList.findAll { it.sum() > 5 }}\n"
            break
        case 'findResults':
            example += "map = $map\n"
            example += "map.findResults { k, v -> if (v % 2 != 0) { v - 2 >= 1 ? v * \"\$v\" : null } } }: " +
                    "${map.findResults { k, v -> if (v % 2 != 0) { v - 2 >= 1 ? k * v : null } } }\n\n"
            example += "listOfList = $listOfList\n"
            example += "listOfList.findResults { if (it.sum() >= 7) { it.sum() == 11 ? 'eleven' : 'seven' } }: " +
                    "${listOfList.findResults { if (it.sum() >= 7) { it.sum() == 11 ? 'eleven' : 'seven' } }}\n"
            break
        case 'flatten':
            example += "listOfList = $listOfList\n"
            example += "listOfList.flatten(): ${listOfList.flatten()}\n\n"
            example += "originalList << additionalList: ${originalList << additionalList}\n"
            example += "(originalList << additionalList).flatten(): ${originalList.flatten()}\n"
            break
        case 'containsAll':
            example += "originalList = $originalList\n"
            example += "originalList.containsAll(['a', 'c']): ${originalList.containsAll(['a', 'c'])}\n"
            example += "originalList.containsAll(['c', 'd']): ${originalList.containsAll(['c', 'd'])}\n"
            break
        case 'count':
            example += "listWithDuplicates = $listWithDuplicates\n"
            example += "listWithDuplicates.count('a'): ${listWithDuplicates.count('a')}\n"
            example += "listWithDuplicates.count('d'): ${listWithDuplicates.count('d')}\n"
            break
        case 'sum':
            example += "listOfList.flatten(): ${listOfList.flatten()}\n"
            example += "listOfList.flatten().sum(): ${listOfList.flatten().sum()}\n\n"
            example += "listOfMaps = $listOfMaps\n"
            example += "listOfMaps.sum { it.id }: ${listOfMaps.sum { it.id }}\n"
            break
        case 'each':
            example += "emptyString = ''\n"
            example += "map = $map\n"
            example += "map.each { k, v -> emptyString += k * v }: "
            map.each { k, v -> emptyString += k * v }
            example += "$emptyString\n"
            break
        case 'eachWithIndex':
            example += "emptyString = ''\n"
            example += "map = $map\n"
            example += "map.eachWithIndex { k, v, index -> emptyString += index + (k * v) }: "
            map.eachWithIndex { k, v, index -> emptyString += index + (k * v) }
            example += "$emptyString\n"
            break
        case 'groupBy':
            example += "listOfIntegers = ${listOfIntegers}\n"
            example += "listOfIntegers.groupBy { it % 2 }: "
            example += "${listOfIntegers.groupBy { it % 2 }}\n"
            break
        case 'join':
            example += "listOfStrings = ${listOfStrings}\n"
            example += "listOfStrings.join(): "
            example += "${listOfStrings.join()}\n"
            example += "listOfStrings.join(','): "
            example += "${listOfStrings.join(',')}\n"
            break
        case 'split':
            example += "listOfStrings.join(','): ${listOfStrings.join(',')}\n"
            example += "listOfStrings.join(',').split(','): "
            example += "${listOfStrings.join(',').split(',')}\n"
            example += "listOfStrings.join(',').split(',') == listOfStrings: "
            example += "${listOfStrings.join(',').split(',') == listOfStrings}\n"
            break
        case 'first':
            Collections.shuffle(listOfIntegers)
            example += "listOfIntegers = ${listOfIntegers}\n"
            example += "listOfIntegers.first(): ${listOfIntegers.first()}\n"
            break
        case 'last':
            Collections.shuffle(listOfIntegers)
            example += "listOfIntegers = ${listOfIntegers}\n"
            example += "listOfIntegers.last(): ${listOfIntegers.last()}\n"
            break
        case 'max':
            Collections.shuffle(listOfIntegers)
            example += "listOfIntegers = ${listOfIntegers}\n"
            example += "listOfIntegers.max(): ${listOfIntegers.max()}\n"
            break
        case 'min':
            Collections.shuffle(listOfIntegers)
            example += "listOfIntegers = ${listOfIntegers}\n"
            example += "listOfIntegers.min(): ${listOfIntegers.min()}\n"
            break
        default:
            println "exampleName '$exampleName' not found"
            return
    }

    String header = "| Example: $exampleName |"
    String underline = "-" * header.length()
    List<String> printout = [underline, header, underline, example]
    println "\n${printout.join('\n')}"

    if (exampleName == 'times') {
        number.times(printHelloWorld)
        println()
    }
} else {
    cliBuilder.usage()
}



