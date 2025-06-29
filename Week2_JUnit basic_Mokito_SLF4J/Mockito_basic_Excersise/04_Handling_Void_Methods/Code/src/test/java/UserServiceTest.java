import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testRegisterUser_sendsEmail() {
        NotificationService mockNotificationService = mock(NotificationService.class);

        doNothing().when(mockNotificationService).sendEmail(anyString());

        UserService userService = new UserService(mockNotificationService);
        userService.registerUser("Sneaga");

        verify(mockNotificationService, times(1)).sendEmail("Welcome Sneaga!");
    }
}