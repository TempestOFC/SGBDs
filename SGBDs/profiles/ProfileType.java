package profiles;

public enum ProfileType {
    FREE,      // 1) Gratuito -> Single usuário e banco de dados de transações únicas
    BASIC,     // 2) Básico -> multi usuário mas com banco de dados de transações únicas
    ULTIMATE   // 3) Ultimate -> Multi usuário e banco de dados com múltiplas transações
}