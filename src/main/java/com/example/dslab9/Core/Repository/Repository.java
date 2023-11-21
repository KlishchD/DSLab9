package com.example.dslab9.Core.Repository;

import com.example.dslab9.Core.Models.Album;
import com.example.dslab9.Core.Models.Artist;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Repository extends Remote {
    int countArtists();
    int countAlbums();

    void insertArtist(Artist artist);
    void insertAlbum(int artistId, Album album);

    void deleteArtist(int id);
    void deleteAlbum(int id);

    Artist getArtists(int id);
    Album getAlbum(int id);

    List<Artist> getArtists();
    List<Album> getAlbums();
}
