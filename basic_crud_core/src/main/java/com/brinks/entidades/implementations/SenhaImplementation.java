package com.brinks.entidades.implementations;

import com.brinks.entidades.Senha;
import com.brinks.entidades.implementations.exceptions.CriptografiaException;
import com.brinks.entidades.implementations.validation_rules.SenhaValidationRule;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.regex.Pattern;

public class SenhaImplementation extends Senha{
    @Override
    public Boolean temPropriedadesValidas() {
        return Pattern.compile(SenhaValidationRule.REGEX).matcher(this.desencriptado).matches();
    }

    @Override
    public void setDesencriptado(String valor) {
        this.desencriptado = valor;
        this.gerarSal();
        this.encriptado = this.criptografar(this.desencriptado);
    }

    @Override
    public void setEncriptado(String valor) {
        this.encriptado = valor;
    }

    @Override
    protected String criptografar(String valor) {
        try {
            var spec = new PBEKeySpec(valor.toCharArray(), this.sal, 8000, 128  );
            var criptografiaFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            var valorCriptografadoEmBytes = criptografiaFactory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(valorCriptografadoEmBytes);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException exception) {
            throw new CriptografiaException(exception);
        }
    }

    @Override
    protected void gerarSal() {
        new SecureRandom().nextBytes(this.sal);
    }

    @Override
    protected Boolean ehIgualA(String outroValorNaoCriptografado) {
        return this.encriptado.equals(this.criptografar(outroValorNaoCriptografado));
    }
}
