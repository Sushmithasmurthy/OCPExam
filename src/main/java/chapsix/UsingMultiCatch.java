package chapsix;

import org.omg.IOP.IOR;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 5/22/17.
 */
public class UsingMultiCatch {
    public static void main(String... args) throws IOException {
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            out.println(date);
        } catch (DateTimeParseException | IOException e) { //Multiple exceptions can be handled and caught in the same way.
            e.printStackTrace();
            throw new RuntimeException(); //Its ok even if its not declared in the main declaration as its run time exception.
        }
    }

    private void multipleIOExceptionCatch() {
        try {
            throw new IOException();
            //types in multicatch must be disjoint FilenotFoundexception is a subcalss of IO Exception
        }//catch(FileNotFoundException|IOException e){
        catch (IOException e) {
        }
    }

    private void reassignVariableinaCatchBlk_BADIDEA() {
        try {
            //do some work
        } catch (RuntimeException e) {
            e = new RuntimeException(); //#1 - Compiles but DO NOT do this.
        }
        try {
            throw new IOException();
        } catch (IOException | RuntimeException o) {
            //You can not do what u did in #1 here - for multicatch variable is effectively final
            // o = new RuntimeException();
        }

        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException | IllegalStateException e) {

        }
        try {
            mightThrow();
        } catch (DateTimeParseException | FileNotFoundException | IllegalStateException e) {
            // Incorrect- only one exception variable per block
            //  catch(InputMismatchException e|MissingResourceException e){}
            //}SQL is compile time execption -- it is a checked exception and
            // can be caught only if the enclosing block has the potential to throw this execption.
            //catch(SQLException |ArrayIndexOutOfBoundsException e){
            //FileNotFound exception is already caught hence you cannot catch it again
            //}catch(FileNotFoundException |IllegalArgumentException e) {
        } catch (Exception e) {
            //This should come before the above line -- specifc exception need to be caught before generic ex.
            //}catch(IOException e) {
        }

    }

    private void mightThrow() throws DateTimeParseException, IOException {

    }

}
