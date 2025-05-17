import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:appcendikiawan/models/user_model.dart';

class FirestoreService {
  final CollectionReference _usersCollection =
  FirebaseFirestore.instance.collection('users');

  Future<void> addUser(UserModel user) async {
    try {
      await _usersCollection.doc(user.id).set(user.toMap());
    } catch (e) {
      print('Error adding user: $e');
      throw e;
    }
  }

  Stream<List<UserModel>> getUsers() {
    return _usersCollection.snapshots().map((snapshot) {
      return snapshot.docs.map((doc) {
        return UserModel.fromMap(doc.data() as Map<String, dynamic>);
      }).toList();
    });
  }

  Future<void> updateUser(UserModel user) async {
    try {
      await _usersCollection.doc(user.id).update(user.toMap());
    } catch (e) {
      print('Error updating user: $e');
      throw e;
    }
  }

  Future<void> deleteUser(String userId) async {
    try {
      await _usersCollection.doc(userId).delete();
    } catch (e) {
      print('Error deleting user: $e');
      throw e;
    }
  }
}
