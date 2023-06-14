package dao;

import database.DatabaseConnection;
import dto.BlogDto;
import exception.BadRequestException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BlogDao implements IDaoGenerics<BlogDto> {
    @Override
    public void Create(BlogDto blogDto) {
        try(Connection connection=getInterfaceConnection()) {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO onepage.blog(header,content) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);//prepared statement java ile database arasındaki bağlantıyı kurar
            preparedStatement.setString(1, blogDto.getHeader());
            preparedStatement.setString(2, blogDto.getContent());

            // Ekleme yapılsın
            // preparedStatement.executeUpdate() --> CREATE, DELETE, UPDATE
            // preparedStatement.executeQuery() --> SELECT
            Integer rowsEffected = preparedStatement.executeUpdate(); // rows --> 0'dan büyükse eklendi, -1 ise eklenmedi
            if (rowsEffected > 0 ){
                System.out.println(BlogDto.class + " Eklendi");
                connection.commit();
            }else {
                System.out.println(BlogDto.class + " Hata eklenmedi!");
                connection.rollback();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void Update(BlogDto blogDto) {
        try(Connection connection=getInterfaceConnection()) {
            connection.setAutoCommit(false);
            if (FindById(blogDto.getId()) != null){
                String sql = "UPDATE onePage.blog set header =?,content = ? where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);//prepared statement java ile database arasındaki bağlantıyı kurar
                preparedStatement.setString(1, blogDto.getHeader());
                preparedStatement.setString(2, blogDto.getContent());
                preparedStatement.setLong(3,blogDto.getId());
                // Update yapılsın
                // preparedStatement.executeUpdate() --> CREATE, DELETE, UPDATE
                // preparedStatement.executeQuery() --> SELECT
                Integer rowsEffected = preparedStatement.executeUpdate(); // rows --> 0'dan büyükse eklendi, -1 ise eklenmedi
                if (rowsEffected > 0 ){
                    System.out.println(BlogDto.class + " Güncellendi");
                    connection.commit();
                }else {
                    System.out.println(BlogDto.class + " Hata güncellenmedi!");
                    connection.rollback();
                }
            }else {
                throw new BadRequestException(blogDto.getId() + " Id yok!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(BlogDto blogDto) {
        try(Connection connection=getInterfaceConnection()) {
            connection.setAutoCommit(false);
            if (FindById(blogDto.getId()) != null){
                String sql = "DELETE FROM `onepage`.`blog` WHERE id = ?; ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);//prepared statement java ile database arasındaki bağlantıyı kurar
                preparedStatement.setLong(1,blogDto.getId());
                Integer rowsEffected = preparedStatement.executeUpdate(); // rows --> 0'dan büyükse eklendi, -1 ise eklenmedi
                if (rowsEffected > 0 ){
                    System.out.println(BlogDto.class + " Güncellendi");
                    connection.commit();
                }else {
                    System.out.println(BlogDto.class + " Hata güncellenmedi!");
                    connection.rollback();
                }
            }else {
                throw new BadRequestException(blogDto.getId() + " Id yok!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public BlogDto FindById(Long id) {
        BlogDto blogDto = new BlogDto();
        try(Connection connection = getInterfaceConnection()) {
            String sql = "SELECT * FROM onePage.blog WHERE id=" +id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                blogDto.setId(resultSet.getLong("id"));
                blogDto.setHeader(resultSet.getString("header"));
                blogDto.setContent(resultSet.getString("content"));
                blogDto.setSystemCreatedDate(resultSet.getDate("created_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return blogDto;
    }

    @Override
    public ArrayList<BlogDto> list() {
        ArrayList<BlogDto> blogDtoList = new ArrayList<>();
        BlogDto blogDto;
        try(Connection connection = getInterfaceConnection()) {
            String sql = "SELECT * FROM onepage.blog";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                blogDto = new BlogDto();
                blogDto.setId(resultSet.getLong("id"));
                blogDto.setHeader(resultSet.getString("header"));
                blogDto.setContent(resultSet.getString("content"));
                blogDto.setSystemCreatedDate(resultSet.getDate("created_date"));
                blogDtoList.add(blogDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return blogDtoList;
    }
}
