package br.com.thiagoft.socketmanager.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Utilitário para manipulação com CheckSum
 */
public class CheckSumUtils {

    /**
     * Calcula o Checksum para verificar se a trama está integra.
     * Se o texto passado tiver vazio (= zero size), retorna sempre false.
     *
     * @return true se o checksum estiver ok, e, false, o contrário.
     */
    public static boolean validaCheckSum(String texto, String checkSumInformada) {

        if (StringUtils.isEmpty(texto)) return false;

        String checkSum = calculaCheckSumHexPara(texto);

        return checkSum.equalsIgnoreCase(checkSumInformada);
    }

    /**
     * Realiza o cálculo de checksum para um texto qualquer.
     * @param texto uma string
     * @return o cálculo do checksum em forma numérica.
     */
    public static long calculaCheckSumPara(String texto) {

        char[] chars = texto.toCharArray();

        long resultTemp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            resultTemp ^= chars[i];
        }

        return resultTemp;
    }

    /**
     * Realiza o cálculo de checksum para um texto qualquer.
     * @param texto uma string
     * @return o cálculo do checksum em sistema hexadecimal.
     */
    public static String calculaCheckSumHexPara(String texto) {

        final int QUANTIDE_MINIMA_DIGITOS = 2;

        if (StringUtils.isEmpty(texto)) {
            throw new IllegalArgumentException("Empty String");
        }

        return converteIntegerToHex(calculaCheckSumPara(texto), QUANTIDE_MINIMA_DIGITOS);
    }

    /**
     * Converte um Long para String Hexadecimal especificando a quantidade mínima de digitos desejada.
     */
    public static String converteIntegerToHex(Long l, int quantideMinimaDigitos) {

        return StringUtils.leftPad(Long.toHexString(l), quantideMinimaDigitos, '0');

    }


}
