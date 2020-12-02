package co.com.bcs.authserverbcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.bcs.authserverbcs.domain.Credentials;

/**
 * Created by ahmed on 21.5.18.
 */
public interface CredentialRepository extends JpaRepository<Credentials,Long> {
    Credentials findByName(String name);
}
