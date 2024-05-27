package br.com.alura.challenge.literalura.model;

public enum LanguagesEnum {
    Inglês("en"),
    Português("pt");

    private String languageGutendex;

    LanguagesEnum(String languageGutendex) {
        this.languageGutendex = languageGutendex;
    }

    public static LanguagesEnum fromString (String language) {
        for (LanguagesEnum languagesEnum : LanguagesEnum.values()) {
            if (languagesEnum.languageGutendex.equalsIgnoreCase(language)) {
                return languagesEnum;
            }
        }
        throw new IllegalArgumentException("Nenhuma linguagem se encaixa aqui!");
    }
}
