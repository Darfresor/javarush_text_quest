package entity;

import com.javarush.textquest.ostapenko.model.entity.User;
import com.javarush.textquest.ostapenko.model.entity.UserRoles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class UserTest {
    User user;

    @Test
    void givenNameAndPassword_whenCreatingUser_thenAllFieldsSetCorrectly() {
        user = new User("name","password");
        Set<UserRoles> roles = user.getUserRoles();
        assertThat(user.getName(),is("name"));
        assertThat(user.getPassword(),is("password"));
        assertThat(roles,is(notNullValue()));
        assertThat(roles.size(),is(1));
        assertThat(roles,hasItem(UserRoles.BASE));
    }
    @Test
    void givenNameAndPasswordAndNumberOfGame_whenCreatingUser_thenAllFieldsSetCorrectly() {
        user = new User("name","password",0L);
        Set<UserRoles> roles = user.getUserRoles();
        assertThat(user.getName(),is("name"));
        assertThat(user.getPassword(),is("password"));
        assertThat(user.getNumberOfGamesPlayed(),is(0L));
        assertThat(roles,is(notNullValue()));
        assertThat(roles.size(),is(1));
        assertThat(roles,hasItem(UserRoles.BASE));
    }

    @Test
    void givenNewName_whenSetName_thenNameShouldBeUpdated() {
        user = new User();
        user.setName("test-user");
        assertThat(user.getName(), is("test-user"));
    }

    @Test
    void givenNewPassword_whenSetPassword_thenPasswordShouldBeUpdated(){
        user = new User("name","password");
        user.setPassword("newPassword");
        assertThat(user.getPassword(),is("newPassword"));
    }
    @Test
    void givenNewNumberOfGame_whenSetNumberOfGamesPlayed_thenNumberOfGamesPlayedShouldBeUpdated(){
        user = new User("name","password",0L);
        user.setNumberOfGamesPlayed(2L);
        assertThat(user.getNumberOfGamesPlayed(),is(2L));
    }

    @Test
    void givenNewRole_whenSetUserRoles_thenUserRolesShouldBeUpdated(){
        user = new User("name","password",0L);
        Set<UserRoles> newRoles = new HashSet<>();
        newRoles.add(UserRoles.ADMIN);
        user.setUserRoles(newRoles);
        Set<UserRoles> roles = user.getUserRoles();
        assertThat(roles,is(notNullValue()));
        assertThat(roles.size(),is(1));
        assertThat(roles,hasItem(UserRoles.ADMIN));
    }
}
